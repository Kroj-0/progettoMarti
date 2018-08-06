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

    @OneToMany(mappedBy = "tracking",cascade = CascadeType.ALL)
    private Set<CustomerOrder> customerOrder;

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

    public Set<CustomerOrder> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Set<CustomerOrder> customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Date getDate() {
        return updatedOn;
    }

    public void setDate(Date date) {
        this.updatedOn = date;
    }
}
