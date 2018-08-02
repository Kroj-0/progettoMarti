package com.emusicstore.service;

import com.emusicstore.model.ShippingAddress;

import java.util.List;

public interface ShippingAdrService {
    List<ShippingAddress> getCustomerSas(int customerId);
    void addShippingAddress(ShippingAddress sa);
    void editShippingAddress(ShippingAddress sa);
    void deleteShippingAddress(ShippingAddress sa);
    ShippingAddress getSa(int saId);
}
