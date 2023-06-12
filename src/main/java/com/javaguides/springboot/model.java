package com.javaguides.springboot;

public class model {
    public int listingNumber;
    public String street_address;
    public String street_name;

    public String city;

    public String state;

    public int zip;

    public int cost;


    public int getListingNumber() {
        return listingNumber;
    }

    public void setListingNumber(int listingNumber) {
        this.listingNumber = listingNumber;
    }


    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
