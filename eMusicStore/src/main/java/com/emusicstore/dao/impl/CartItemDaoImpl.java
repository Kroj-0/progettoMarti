package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartItemDao;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void clearCart(Cart cart) {

        List<CartItem> cartItemList=cart.getCartItems();

        for(CartItem cartItem : cartItemList){
            removeCartItem(cartItem);
        }
    }
    public CartItem getCartItemByProductId(int productId, int cartId){

        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from CartItem where productId = ? and cartId = ?");
        query.setInteger(0, productId);
        query.setInteger(1, cartId);

        return (CartItem) query.uniqueResult();
    }

    public void updateCartItemQuantity(CartItem cartItem){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }
}
