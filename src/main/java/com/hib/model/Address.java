package com.hib.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name="Address_country")
    private String aCountry;

    @Column(name ="Address_city")
    private String aCity;

    @Column(name = "Address_street")
    private String aStreet;

    @Column(name = "Address_number")
    private String aNumber;

    public Address() {
    }

    public Address(String aCountry, String aCity, String aStreet, String aNumber) {
        this.aCountry = aCountry;
        this.aCity = aCity;
        this.aStreet = aStreet;
        this.aNumber = aNumber;
    }

    public String getaCountry() {
        return aCountry;
    }

    public void setaCountry(String aCountry) {
        this.aCountry = aCountry;
    }

    public String getaCity() {
        return aCity;
    }

    public void setaCity(String aCity) {
        this.aCity = aCity;
    }

    public String getaStreet() {
        return aStreet;
    }

    public void setaStreet(String aStreet) {
        this.aStreet = aStreet;
    }

    public String getaNumber() {
        return aNumber;
    }

    public void setaNumber(String aNumber) {
        this.aNumber = aNumber;
    }
}
