package com.emusicstore.model;

public class CartItem {

    private Product product;
    private int quantity;
    private double total;

    public CartItem(){}

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.total = product.getProductPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
}
