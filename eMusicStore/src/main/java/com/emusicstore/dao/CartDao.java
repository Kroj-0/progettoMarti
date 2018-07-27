package com.emusicstore.dao;

import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.io.IOException;


public interface CartDao {

    Cart getCartById(int cartId);
    void update(Cart cart);
    Cart validate(int cartId) throws IOException;

}
