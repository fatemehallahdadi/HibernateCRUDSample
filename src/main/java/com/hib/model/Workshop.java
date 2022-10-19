package com.hib.model;

public class Workshop {


    private String name ;
    private boolean offerDegree ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOfferDegree() {
        return offerDegree;
    }

    public void setOfferDegree(boolean offerDegree) {
        this.offerDegree = offerDegree;
    }

    public Workshop(String name, boolean offerDegree) {
        this.name = name;
        this.offerDegree = offerDegree;
    }

    public Workshop() {
    }

    @Override
    public String toString() {
        return "Workshop{" +
                "name='" + name + '\'' +
                ", offerDegree=" + offerDegree +
                '}';
    }
}
