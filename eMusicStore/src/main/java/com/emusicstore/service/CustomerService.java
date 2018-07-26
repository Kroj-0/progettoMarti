package com.emusicstore.service;


import com.emusicstore.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    List<Customer> getCustomerList();
    Customer getCustomerByUsername(String username);
}
