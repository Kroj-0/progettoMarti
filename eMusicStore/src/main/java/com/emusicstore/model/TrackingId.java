package com.emusicstore.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrackingId implements Serializable {

    @Column(name = "trackingId")
    private String trackingId;

    @Column(name = "status")
    private String status;

    public  TrackingId(){}

    public TrackingId(String trackingId, String status) {
        this.trackingId = trackingId;
        this.status = status;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrackingId)) return false;
        TrackingId that = (TrackingId) o;
        return Objects.equals(getTrackingId(), that.getTrackingId()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrackingId(), getStatus());
    }
}
