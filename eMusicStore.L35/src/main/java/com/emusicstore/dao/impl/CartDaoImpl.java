package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;

import java.util.HashMap;
import java.util.Map;

public class CartDaoImpl implements CartDao {

    private Map<Integer, Cart> cartList;

    public CartDaoImpl(){
        cartList=new HashMap<Integer, Cart>();
    }

    public Cart create(Cart cart){
        if(cartList.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Cannot create a cart with this id, id=(%) already exists for another cart", cart.getCartId()));
        }

        cartList.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(int cartId){
        return cartList.get(cartId);
    }

    public void update(int cartId, Cart cart){
        if(!cartList.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot update a cart with this id, id=(%) doesn't exist", cart.getCartId()));
        }
        cartList.put(cartId, cart);
    }

    public void delete(int cartId){
        if(!cartList.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot delete a cart with this id, id=(%) doesn't exist", cartId));
        }
        cartList.remove(cartId);
    }
}
