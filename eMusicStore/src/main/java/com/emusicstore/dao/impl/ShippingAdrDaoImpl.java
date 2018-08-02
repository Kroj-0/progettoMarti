package com.emusicstore.dao.impl;

import com.emusicstore.dao.ShippingAdrDao;
import com.emusicstore.model.ShippingAddress;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ShippingAdrDaoImpl implements ShippingAdrDao{

    @Autowired
    private SessionFactory sessionFactory;

    public List<ShippingAddress> getCustomerSas(int customerId){
        Session session=sessionFactory.getCurrentSession();
        Query query= session.createQuery("from ShippingAddress where customer.customerId = ?");
        query.setInteger(0, customerId);
        List<ShippingAddress> addresses=query.list();
        session.flush();

        return addresses;
    }

    public void addShippingAddress(ShippingAddress sa){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(sa);
        session.flush();
    }
    public void editShippingAddress(ShippingAddress sa){
        Session session=sessionFactory.getCurrentSession();
        System.out.println(">>>>>>>>> sa id: "+ sa.getShippingAddressId());
        session.update(sa);
        session.flush();
    }
    public void deleteShippingAddress(ShippingAddress sa){
        Session session=sessionFactory.getCurrentSession();
        session.delete(sa);
        session.flush();
    }

    public ShippingAddress getSa(int saId){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from ShippingAddress where shippingAddressId = ?");
        query.setInteger(0,saId);
        ShippingAddress sa=(ShippingAddress)query.uniqueResult();

        session.flush();
        return sa;
    }
}
