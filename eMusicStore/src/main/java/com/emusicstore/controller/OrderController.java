package com.emusicstore.controller;

import com.emusicstore.model.*;
//import com.emusicstore.model.OrderDetail;
import com.emusicstore.service.*;
//import com.emusicstore.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TrackingService trackingService;

    @RequestMapping("/order/{cartId}")
    public  String goToCheckout(@PathVariable("cartId") int cartId){

        return "redirect:/checkout?cartId="+cartId;
    }
    @RequestMapping("/checkout-ended")
    public String createOrder() {

        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(">>>>>> username from jsessionid= " + currentUserName);

        Customer customer=customerService.getCustomerByUsername(currentUserName);
        CustomerOrder customerOrder=new CustomerOrder();
        Cart cart=cartService.getCartById(customer.getCart().getCartId());
        List<CartItem> cartItemList=cart.getCartItems();
        Date date=new Date();
        int OrderId=customerOrderService.getLastOrderId();
        System.out.println(">>>>l'ultimo ordine  "+OrderId);
        OrderId++;
        System.out.println(">>>>nuovo orderId  "+OrderId);
        for(int i=0; i<cartItemList.size();i++){
            CustomerOrderId customerOrderId= new CustomerOrderId(OrderId,cartItemList.get(i).getProduct().getProductId());

            customerOrder.setCart(cart);
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

            // setto il tracking
            customerOrder.setDate(date);
            String trId=trackingService.setTracking(customer.getShippingAddress().getShippingAddressId());
            TrackingId trackingId=new TrackingId(trId,"confirmed");
            Tracking tracking=new Tracking(trackingId, date);
            trackingService.addTracking(tracking);

            customerOrder.setTracking(tracking);
            customerOrderService.addCustomerOrder(customerOrder);
            System.out.println(">>>>>Devo farlo "+cartItemList.size()+" volte");

            //elimino la quantita comprata dallo stock
            int ordered=cartItemList.get(i).getQuantity();
            Product product=productService.getProductById(cartItemList.get(i).getProduct().getProductId());
            int updateUIS=product.getUnitInStock()-ordered;
            System.out.println(">>>>> old UIS = "+product.getUnitInStock()+" new UIS = "+updateUIS);
            product.setUnitInStock(updateUIS);
            productService.editProduct(product);

        }
        cartItemService.clearCart(customer.getCart());
        return "redirect:/";
    }
}
