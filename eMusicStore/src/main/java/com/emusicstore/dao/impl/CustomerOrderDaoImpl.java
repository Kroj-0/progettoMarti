package com.emusicstore.dao.impl;

import com.emusicstore.dao.CustomerOrderDao;
import com.emusicstore.model.CustomerOrder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder){
        Session session=sessionFactory.getCurrentSession();
        session.save(customerOrder);
        session.flush();
    }

    public int getLastOrderId() {

        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("select distinct max(cast(OrderId as int)) from CustomerOrder");
        session.flush();
        if(query.uniqueResult()==null){
            int firstOrderId=0;
            return firstOrderId;
        }
        else{
            int lastOrderId=(Integer) query.uniqueResult();
            return  lastOrderId;
        }

    }

    public List<CustomerOrder> getAllOrders() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from CustomerOrder order by date desc");
        List<CustomerOrder> customerOrderList=query.list();
        session.flush();

        return customerOrderList;
    }

    public List<CustomerOrder> getOrdersByCustomerId(int customerId) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from CustomerOrder where CustomerId = ? order by date desc");
        query.setInteger(0, customerId);
        List<CustomerOrder> customerOrderList=query.list();
        session.flush();

        return customerOrderList;
    }

    public List<CustomerOrder> getLinkedOrders(CustomerOrder customerOrder) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from CustomerOrder where CustomerId = ? and OrderId = ? and ProductId <> ?");
        query.setInteger(0, customerOrder.getCustomer().getCustomerId());
        query.setInteger(1, customerOrder.getCustomerOrderId().getOrderId());
        query.setInteger(2, customerOrder.getProduct().getProductId());
        List<CustomerOrder> customerOrderList=query.list();
        session.flush();

        return customerOrderList;
    }

    public CustomerOrder getOrdersByKey(int productId, int orderId) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from CustomerOrder where OrderId = ? and productId = ?");
        query.setInteger(0, orderId);
        query.setInteger(1, productId);
        CustomerOrder customerOrder=(CustomerOrder) query.uniqueResult();
        session.flush();
        return customerOrder;
    }

    public void update(CustomerOrder customerOrder) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();

    }

    public CustomerOrder getFromTracking(String trackingId) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from CustomerOrder where trackingId = ?");
        query.setString(0, trackingId);
        CustomerOrder customerOrder=(CustomerOrder)query.uniqueResult();
        session.flush();
        return customerOrder;
    }

}
