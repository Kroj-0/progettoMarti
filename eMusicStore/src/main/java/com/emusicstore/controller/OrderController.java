package com.emusicstore.controller;

import com.emusicstore.model.*;
//import com.emusicstore.model.OrderDetail;
import com.emusicstore.service.CartService;
import com.emusicstore.service.CustomerOrderService;
//import com.emusicstore.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){

        CustomerOrder customerOrder=new CustomerOrder();
        Cart cart=cartService.getCartById(cartId);
        List<CartItem> cartItemList=cart.getCartItems();
        Date date=new Date();
        int OrderId=customerOrderService.getLastOrderId();
        System.out.println(">>>>l'ultimo ordine  "+OrderId);
        OrderId++;
        System.out.println(">>>>nuovo orderId  "+OrderId);
        for(int i=0; i<cartItemList.size();i++){
            CustomerOrderId customerOrderId= new CustomerOrderId(OrderId,cartItemList.get(i).getProduct().getProductId());

            customerOrder.setCart(cart);
            Customer customer=cart.getCustomer();
            customerOrder.setCustomer(customer);

            System.out.println(">>>>inserisco "+customerOrder.getCustomer());
            customerOrder.setBillingAddress(customer.getBillingAddress());
            customerOrder.setShippingAddress(customer.getShippingAddress());

            System.out.println(">>>>inserisco il prodotto "+customerOrderId.getProductId()+" e l'id ordine "+ customerOrderId.getOrderId());
            customerOrder.setCustomerOrderId(customerOrderId);
            System.out.println(">>>>inserisco la quantita "+cartItemList.get(i).getQuantity());
            customerOrder.setQuantity(cartItemList.get(i).getQuantity());
            System.out.println(">>>>inserisco il prezzo per unita "+cartItemList.get(i).getProduct().getProductPrice());
            customerOrder.setUnitPrice(cartItemList.get(i).getProduct().getProductPrice());
            System.out.println(">>>>inserisco il totale "+cartItemList.get(i).getTotal());
            customerOrder.setTotal(cartItemList.get(i).getTotal());

            customerOrder.setDate(date);
            customerOrder.setStatus("confirmed");
            System.out.println(">>>>inserisco lo stato "+customerOrder.getStatus());
            customerOrderService.addCustomerOrder(customerOrder);
            System.out.println(">>>>>Devo farlo "+cartItemList.size()+" volte");
        }

        return "redirect:/checkout?cartId="+cartId;
    }
}
