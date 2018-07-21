package com.emusicstore.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Billing_address")
public class BillingAddress implements Serializable{

    private static final long serialVersionUID = -6091579459463730482L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingAddressId;
    private String streetName;
    private String aptNumber;
    private String city;
    private String state;
    private String cap;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return "BillingAddress{" +
                "streetName='" + streetName + '\'' +
                ", aptNumber='" + aptNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", cap='" + cap + '\'' +
                '}';
    }

    public int getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(int billingAddressId) {
        this.billingAddressId = billingAddressId;
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
