package com.emusicstore.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="shipping_address")
public class ShippingAddress implements Serializable {

    private static final long serialVersionUID = 989191150380037359L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shippingAddressId;
    private String streetName;
    private String aptNumber;
    private String city;
    private String state;
    private String cap;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "streetName='" + streetName + '\'' +
                ", aptNumber='" + aptNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", cap='" + cap + '\'' +
                '}';
    }

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
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

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
