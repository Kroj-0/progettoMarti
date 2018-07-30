package com.emusicstore.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerOrderId implements Serializable {

    @Column(name = "OrderId")
    private int OrderId=1;

    @Column(name = "productId")
    private int productId;

    public CustomerOrderId() {
    }

    public CustomerOrderId(int OrderId, int productId) {
        this.OrderId=OrderId;
        this.productId=productId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerOrderId)) return false;
        CustomerOrderId that = (CustomerOrderId) o;
        return Objects.equals(getOrderId(), that.getOrderId()) &&
                Objects.equals(getProductId(), that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getProductId());
    }
}
