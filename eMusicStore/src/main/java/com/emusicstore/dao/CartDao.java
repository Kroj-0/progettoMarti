package com.emusicstore.dao;

import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;


public interface CartDao {

    Cart getCartById(int cartId);
    void update(Cart cart);

}
