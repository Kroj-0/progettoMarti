package com.emusicstore.service.impl;

import com.emusicstore.dao.ShippingAdrDao;
import com.emusicstore.model.ShippingAddress;
import com.emusicstore.service.ShippingAdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingAdrServiceImpl implements ShippingAdrService {

    @Autowired
    private ShippingAdrDao shippingAdrDao;

    public List<ShippingAddress> getCustomerSas(int customerId) {
        return shippingAdrDao.getCustomerSas(customerId);
    }

    public void addShippingAddress(ShippingAddress sa) {
        shippingAdrDao.addShippingAddress(sa);
    }

    public void editShippingAddress(ShippingAddress sa) {
        shippingAdrDao.editShippingAddress(sa);
    }

    public void deleteShippingAddress(ShippingAddress sa) {
        shippingAdrDao.deleteShippingAddress(sa);
    }

    public ShippingAddress getSa(int saId) {
        return shippingAdrDao.getSa(saId);
    }
}
