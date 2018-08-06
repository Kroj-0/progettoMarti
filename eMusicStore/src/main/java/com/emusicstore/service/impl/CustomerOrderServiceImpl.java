package com.emusicstore.service.impl;


import com.emusicstore.dao.CustomerOrderDao;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.CustomerOrder;
import com.emusicstore.service.CartService;
import com.emusicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    private CustomerOrderDao customerOrderDao;
    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getOrderTotal(int cartId) {
        double total = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            total += item.getTotal();
        }

        return total;
    }

    public int getLastOrderId() {
        return customerOrderDao.getLastOrderId();
    }

    public List<CustomerOrder> getAllOrders() {
        return customerOrderDao.getAllOrders();
    }
    public List<CustomerOrder> getOrdersByCustomerId(int customerId){
        return  customerOrderDao.getOrdersByCustomerId(customerId);
    }

    public CustomerOrder getOrdersByKey(int productId, int orderId){
        return customerOrderDao.getOrdersByKey(productId,orderId);
    }

    public List<CustomerOrder> getLinkedOrders(CustomerOrder customerOrder) {
        return customerOrderDao.getLinkedOrders(customerOrder);
    }

    public void update(CustomerOrder customerOrder) {
        customerOrderDao.update(customerOrder);
    }

    public CustomerOrder getFromTracking(String trackingId) {
        return customerOrderDao.getFromTracking(trackingId);
    }

}
