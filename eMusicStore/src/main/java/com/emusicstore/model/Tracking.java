package com.emusicstore.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tracking")
public class Tracking implements Serializable {

    private static final long serialVersionUID = -8470131953930920479L;

    @EmbeddedId
    private TrackingId trackingId;

    @OneToOne(mappedBy = "tracking",cascade = CascadeType.ALL)
    private CustomerOrder customerOrder;

    @Column(name = "updatedOn", columnDefinition="DATETIME")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedOn;

    public Tracking(){}

    public Tracking(TrackingId trackingId, Date updatedOn) {
        this.trackingId = trackingId;
        this.updatedOn = updatedOn;
    }

    public TrackingId getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(TrackingId trackingId) {
        this.trackingId = trackingId;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public Date getDate() {
        return updatedOn;
    }

    public void setDate(Date date) {
        this.updatedOn = date;
    }
}
