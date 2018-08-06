package com.emusicstore.service;

import com.emusicstore.model.Tracking;

import java.util.List;

public interface TrackingService {
    void addTracking(Tracking tracking);
    Tracking getTracking(String trackingId, String status);
    String setTracking(int saId);
    List<Tracking> getTrackingById(String trackingId);
}
