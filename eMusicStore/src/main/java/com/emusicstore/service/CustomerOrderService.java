package com.emusicstore.service;

import com.emusicstore.model.CustomerOrder;

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);
    double getOrderTotal(int cartId);
}
