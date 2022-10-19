package com.hib.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {


    @Column(name = "country")
    private String countryName;

    @Column(name = "city")
    private String cityName;

    @Column(name = "street")
    private String streetName;

    @Column(name = "number")
    private Integer number;

    public Address(String countryName, String cityName, String streetName, Integer number) {

        this.countryName = countryName;
        this.cityName = cityName;
        this.streetName = streetName;
        this.number = number;
    }


    public Address() {


    }


}
