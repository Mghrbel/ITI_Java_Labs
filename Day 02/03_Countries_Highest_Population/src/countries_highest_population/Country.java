/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries_highest_population;

/**
 *
 * @author MghrbelTemp
 */
public class Country {
    private String countryName;
    private String countryID;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public Country(String countryName, String countryID) {
        this.countryName = countryName;
        this.countryID = countryID;
    }
    
    @Override
    public String toString() {
        return this.countryName;
    }
}
