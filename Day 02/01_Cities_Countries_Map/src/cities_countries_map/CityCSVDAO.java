package MYPACKAGE;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CityCSVDAO {
    String Path;
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
            List<String> lines = Files.readAllLines(citiesFile.toPath());
            for (int cityIndex = 1; cityIndex < lines.size(); cityIndex++) {
                String line = lines.get(cityIndex);
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    City city = new City(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], Double.parseDouble(fields[4]));
                    cities.add(city);
                }
            }
        } catch (IOException ex) {
            System.out.println("File not found");
        }
        return cities;
    }
}
