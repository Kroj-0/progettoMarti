package com.emusicstore.dao.impl;

import com.emusicstore.dao.TrackingDao;
import com.emusicstore.model.Tracking;
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
public class TrackingDaoImpl implements TrackingDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addTracking(Tracking tracking) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(tracking);
        session.flush();
    }

    public List<Tracking> getTrackingById(String trackingId) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Tracking where trackingId.trackingId = ? order by updatedOn asc");
        query.setString(0, trackingId);

        List<Tracking> tracking=query.list();
        session.flush();
        return tracking;
    }

    public Tracking getTracking(String trackingId, String status) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Tracking where trackingId = ? and status = ?");
        query.setString(0, trackingId);
        query.setString(1, status);

        Tracking tracking=(Tracking)query.uniqueResult();
        session.flush();
        return tracking;
    }

    public String setTracking(int saId){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("select state from ShippingAddress where shippingAddressId = ?");
        query.setInteger(0, saId);
        String state=query.uniqueResult().toString();
        System.out.println(">>>>> state="+state);
        session.flush();

        Random rand = new Random();
        int num = rand.nextInt(9000000) + 1000000;
        String track= state.substring(0,2).toUpperCase()+num;
        System.out.println(">>>>> track = "+track);
        return track;
    }
}
