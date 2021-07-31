package cities_countries_map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.toList;


public class Cities_Countries_Map {

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
                
        Map<String , List<City>> sortedCitiesOfCountry = new HashMap<>();
        CitiesOfCountry.forEach((ID,myCities) ->{
            List<City> sortedCities = myCities.stream().sorted(Comparator.comparing(City::getPopulation)).collect(toList());
            sortedCitiesOfCountry.put(ID, sortedCities);
        });
        
        sortedCitiesOfCountry.forEach((ID,myCities) ->
                System.out.println("Country ID : " + ID + " sorted Cities according to population : " + myCities)
        );
    }    
}
