package com.emusicstore.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="customer_order")
public class CustomerOrder implements Serializable{


    private static final long serialVersionUID = 2983360377227484514L;

    @EmbeddedId
    private CustomerOrderId customerOrderId;

    @OneToOne
    @JoinColumn(name="cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="productId", insertable=false, updatable=false)
    private Product product;

    private double unitPrice;
    private int quantity;
    private double total;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name="billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name="shippingAddressId")
    private ShippingAddress shippingAddress;

    private String status;

//    @OneToMany(mappedBy ="customerOrder" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<OrderDetail> orderDetails;


    public CustomerOrderId getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(CustomerOrderId customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
