package countries_highest_population;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Countries_Highest_Population {

    public static void main(String[] args) {
        CountryCSVDAO co = new CountryCSVDAO("src\\main\\resources\\countries.csv");
        List<Country> country = co.readCountryFromCSV();
        CityCSVDAO ci = new CityCSVDAO("src\\main\\resources\\cities.csv");
        List<City> city = ci.readCityFromCSV();
        
       Set<String> countryIDsSet = new HashSet<>();
        for (Country myCountry : country){
            countryIDsSet.add(myCountry.getCountryID());
        }
        
        Map<String , List<City>> CitiesOfCountry = new HashMap<>();
        for (String ID : countryIDsSet){
            List<City> myCities = new ArrayList();
            for (City c : city){
                if (c.getCountryID().equals(ID)){
                    myCities.add(c);
                }
            }
            CitiesOfCountry.put(ID , myCities);
        }
        CitiesOfCountry.forEach((k,v) ->
            System.out.println(k + " " + v.stream().max(Comparator.comparing(City::getPopulation))));
        
        
        
        // Highest population capital
        Optional<City> maxPopulationCapital = city.stream()
                .filter(c -> c.getCapital().equals("primary"))
                .max(Comparator.comparing(City::getPopulation));
        System.out.println("Highest population primary capital is " + maxPopulationCapital);
    }    
}
