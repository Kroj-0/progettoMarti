package com.emusicstore.controller;


import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Product;
import com.emusicstore.service.CartItemService;
import com.emusicstore.service.CartService;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartREST {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    //attraverso @ResponseBody, spring sa che gli arriva un cart, che poi va convertito in JSON
    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById(@PathVariable("cartId") int cartId){
        return cartService.getCartById(cartId);
    }


    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable("productId") int productId, @AuthenticationPrincipal User activeUser){


        Customer customer=customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart=customer.getCart();
        Product product=productService.getProductById(productId);
        List<CartItem> cartItems =cart.getCartItems();

        //il prodotto sta gia nel carrello?
        for(int i=0; i<cartItems.size(); i++){

            if(product.getProductId()==cartItems.get(i).getProduct().getProductId()){
                CartItem cartItem=cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotal(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem=new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotal(product.getProductPrice());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.OK)
    public void removeItem(@PathVariable(value="productId") int productId, @AuthenticationPrincipal User activeUser){

        int cartId=cartService.getCartById(customerService.getCustomerByUsername(activeUser.getUsername()).getCart().getCartId()).getCartId();
        CartItem cartItem=cartItemService.getCartItemByProductId(productId, cartId);

        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value="cartId") int cartId){

        Cart cart =cartService.getCartById(cartId);
        cartItemService.clearCart(cart);
    }

    @RequestMapping(value = "/update/{productId}/{quantity}", method = RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateItem(@PathVariable(value="productId") int productId, @PathVariable(value="quantity") int quantity,
                           @AuthenticationPrincipal User activeUser){
        int cartId=cartService.getCartById(customerService.getCustomerByUsername(activeUser.getUsername()).getCart().getCartId()).getCartId();

        CartItem cartItem=cartItemService.getCartItemByProductId(productId, cartId);
        cartItem.setQuantity(quantity);
        cartItem.setTotal(cartItem.getProduct().getProductPrice()*cartItem.getQuantity());
        cartItemService.updateCartItemQuantity(cartItem);
    }

    @RequestMapping(value = "/validate/{quantity}/{productId}", method = RequestMethod.GET)
    public @ResponseBody String validateItemQuantity(@PathVariable("quantity") int quantity ,@PathVariable("productId") int productId){

        Product product=productService.getProductById(productId);
        if(quantity<=product.getUnitInStock()){
            return "true";
        }
        else return "false";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request")
    public void handleClientErrors(Exception e ){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    public void handleServerErrors(Exception e ){}
}
