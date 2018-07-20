package com.emusicstore.dao;

import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao {

    Cart create(Cart cart);
    Cart read(int cartId);
    void update(int cartId, Cart cart);
    void delete(int cartId);
}
