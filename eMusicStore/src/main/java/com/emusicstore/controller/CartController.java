package com.emusicstore.controller;

import com.emusicstore.dao.CartDao;
import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductDao productDao;


    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    //@ResponseBody returns a model object in the form of JSON. Cart goes in HTTPResponseBody, and Spring passes it in JSON format
    public @ResponseBody Cart read(@PathVariable(value="cartId") int cartId){
        return cartDao.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    //@RequestBody is @ResponseBody reverse process: Spring sees a JSON, puts it into a Cart
    public void update(@PathVariable(value = "cartId") int cartId, @RequestBody Cart cart){

        cartDao.update(cartId,cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value="cartId") int cartId){
        cartDao.delete(cartId);
    }

    @RequestMapping(value="/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId")int productId, HttpServletRequest request){
        int sessionId = Integer.parseInt(request.getSession(true).getId());
        Cart cart=cartDao.read(sessionId);

        if(cart==null){
            cart=cartDao.create(new Cart(sessionId));
        }

        Product product= productDao.getProductById(productId);
        if(product==null){
            throw new IllegalArgumentException(new Exception());
        }
        cart.addCartItem(new CartItem(product));
        cartDao.update(sessionId, cart);
    }

    @RequestMapping(value="/remove/{productId}", method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value="productId") int productId, HttpServletRequest request){
        int sessionId = Integer.parseInt(request.getSession(true).getId());
        Cart cart=cartDao.read(sessionId);

        if(cart==null){
            cart=cartDao.create(new Cart(sessionId));
        }

        Product product= productDao.getProductById(productId);
        if(product==null){
            throw new IllegalArgumentException(new Exception());
        }
        cart.removeCartItem(new CartItem(product));
        cartDao.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Illegal request, verify")
    public void handleClientErrors(Exception e){

    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal Server Error")
    public void handleServerErrors(Exception e){

    }

}

