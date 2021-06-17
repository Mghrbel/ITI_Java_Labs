/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries_highest_population;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MghrbelTemp
 */
public class CountryCSVDAO {
    private final String path;
    List<String> lines;
    List<Country> countries;

    public CountryCSVDAO(String Path){
        this.path = Path;
        this.countries = new ArrayList<Country>();
    }
    public List<Country> readCountryFromCSV(){
        try {
            File countriesFile = new File(path);
            lines = Files.readAllLines(countriesFile.toPath());
        } catch (IOException ex) {
            Logger.getLogger(CountryCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int countryIndex=0 ; countryIndex<lines.size() ; countryIndex++){
            String line = lines.get(countryIndex);
            String[] fields = line.split(",");
            Country country = new Country(fields[0] , fields[1]);
            countries.add(country);
        }
        return countries;
    }
}
