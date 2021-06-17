/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cities_countries_map;

/**
 *
 * @author MghrbelTemp
 */
public class City {
    private int cityID;
    private String cityName;
    private String countryID;
    private String capital;
    private double population;

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public City(int cityID, String cityName, String countryID, String capital, double population) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.countryID = countryID;
        this.capital = capital;
        this.population = population;
    }
    
    @Override
    public String toString(){
        return this.getCityName();
    }
}
