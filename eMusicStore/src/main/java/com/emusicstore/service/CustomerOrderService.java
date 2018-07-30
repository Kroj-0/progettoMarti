package com.emusicstore.service;

import com.emusicstore.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);
    double getOrderTotal(int cartId);
    int getLastOrderId();
    List<CustomerOrder> getAllOrders();
    List<CustomerOrder> getOrdersByCustomerId(int customerId);
    CustomerOrder getOrdersByKey(int productId, int orderId);
    List<CustomerOrder> getLinkedOrders(CustomerOrder customerOrder);
    void changeStatus(CustomerOrder customerOrder);

}
