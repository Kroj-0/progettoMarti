package com.emusicstore.dao;

import com.emusicstore.model.Tracking;

import java.util.List;

public interface TrackingDao {

    void addTracking(Tracking tracking);
    Tracking getTracking(String trackingId, String status);
    String setTracking(int saId);
    List<Tracking> getTrackingById(String trackingId);
    void updateStatus(Tracking tracking);
}
