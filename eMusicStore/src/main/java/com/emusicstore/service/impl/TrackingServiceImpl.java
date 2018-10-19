package com.emusicstore.service.impl;

import com.emusicstore.dao.TrackingDao;
import com.emusicstore.model.Tracking;
import com.emusicstore.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private TrackingDao trackingDao;

    public void addTracking(Tracking tracking) {
        trackingDao.addTracking(tracking);
    }

    public Tracking getTracking(String trackingId, String status) {
        return trackingDao.getTracking(trackingId,status);
    }

    public String setTracking(int saId) {
        return trackingDao.setTracking(saId);
    }

    public List<Tracking> getTrackingById(String trackingId) {
        List<Tracking> tracking=trackingDao.getTrackingById(trackingId);
        return tracking;
    }

    public void updateStatus(Tracking tracking) {
        trackingDao.updateStatus(tracking);
    }
}
