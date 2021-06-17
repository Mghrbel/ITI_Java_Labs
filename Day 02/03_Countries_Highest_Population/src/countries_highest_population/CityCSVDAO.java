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
public class CityCSVDAO {
    private final String Path;
    List<String> lines;
    List<City> cities;

    public CityCSVDAO(String Path){
        this.Path = Path;
        this.cities = new ArrayList<>();
    }
    public List<City> readCityFromCSV ()
    {
        try {
            File citiesFile = new File(Path);
            lines = Files.readAllLines(citiesFile.toPath());
        } catch (IOException ex) {
            Logger.getLogger(CityCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int cityIndex=1 ; cityIndex<lines.size() ; cityIndex++){
            String line = lines.get(cityIndex);
            String[] fields = line.split(",");
            if (fields.length == 5){
                if (!fields[4].isEmpty()){
                    City city = new City(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], Double.parseDouble(fields[4]));
                    cities.add(city);
                }
            }
        }
        return cities;
    }
}
