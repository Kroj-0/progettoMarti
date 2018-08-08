package com.emusicstore.service.impl;


import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Customer;
import com.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer){
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getCustomerList() {
        return customerDao.getCustomerList();
    }

    public Customer getCustomerByUsername(String username){
        return customerDao.getCustomerByUsername(username);
    }
    public void editEnable(Customer customer){
        customerDao.editEnable(customer);
    }

    public void editCustomerDetails(Customer customer) {
        customerDao.editCustomerDetails(customer);
    }

    public void updateShAd(Customer customer) {
        customerDao.updateShAd(customer);
    }

    public String getPwd(String username) {
        return customerDao.getPwd(username);
    }
}
