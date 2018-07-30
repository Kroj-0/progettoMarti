package com.emusicstore.dao;

import com.emusicstore.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderDao {
    void addCustomerOrder(CustomerOrder customerOrder);

    int getLastOrderId();

    List<CustomerOrder> getAllOrders();

    List<CustomerOrder> getOrdersByCustomerId(int customerId);

   CustomerOrder getOrdersByKey(int productId, int orderId);

    List<CustomerOrder> getLinkedOrders(CustomerOrder customerOrder);

    void changeStatus(CustomerOrder customerOrder);


}
