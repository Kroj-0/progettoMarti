package com.emusicstore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private int cartId;
    private Map<Integer, CartItem> cartItems = new HashMap<Integer, CartItem>();
    private double total;

    private Cart(){
        cartItems=new HashMap<Integer, CartItem>();
        total=0;
    }

    public Cart(int cartId){
        this();
        this.cartId=cartId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addCartItem(CartItem item){
        int productId =item.getProduct().getProductId();
        if(cartItems.containsKey(productId)) {
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
            cartItems.put(productId, existingCartItem);
        }
        else cartItems.put(productId,item);

        updateTotal();
    }
    public void removeCartItem(CartItem item){
        int productId= item.getProduct().getProductId();
        cartItems.remove(productId);
        updateTotal();
    }
    public void updateTotal(){
        total=0;
        for(CartItem item : cartItems.values()){
            total=total + item.getTotal();
        }
    }
}
