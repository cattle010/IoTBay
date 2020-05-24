/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author jason
 */
public class ShippingAddress implements Serializable {
    private int shippingAddressID;
    private String streetNumber;
    private String streetName;
    private String city;
    private String state;
    private int postcode;
    private String country;

    public ShippingAddress(int shippingAddressID, String streetNumber, String streetName, String city, String state, int postcode, String country) {
        this.shippingAddressID = shippingAddressID;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
    }

    public int getShippingAddressID() {
        return shippingAddressID;
    }

    public void setShippingAddressID(int shippingAddressID) {
        this.shippingAddressID = shippingAddressID;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
