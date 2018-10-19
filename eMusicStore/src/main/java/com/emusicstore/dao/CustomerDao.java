package com.emusicstore.dao;

import com.emusicstore.model.Customer;

import java.util.List;

public interface CustomerDao {

    void addCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    List<Customer> getCustomerList();
    Customer getCustomerByUsername(String username);
    void editEnable(Customer customer);
    void editCustomerDetails(Customer customer);
    void updateShAd(Customer customer);
    String getPwd(String username);
    Customer getCustomerByEmail(String email);
}
