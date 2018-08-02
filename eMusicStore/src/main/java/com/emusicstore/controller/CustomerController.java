package com.emusicstore.controller;


import com.emusicstore.model.Customer;
import com.emusicstore.model.CustomerOrder;
import com.emusicstore.model.Product;
import com.emusicstore.model.ShippingAddress;
import com.emusicstore.service.CustomerOrderService;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.ProductService;
import com.emusicstore.service.ShippingAdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("addresses")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private ShippingAdrService adrService;

    @RequestMapping
    public String customerPage(){
        return "customer";
    }

    @RequestMapping("/myDetails")
    public String getUserDetails(@CookieValue("user") String userCookie, Model model){
        Customer customer=customerService.getCustomerByUsername(userCookie);
        model.addAttribute("user", customer);
        return "viewMyDetail";
    }

    @RequestMapping(value="/myDetails/editName")
    public String editName(@CookieValue("user") String userCookie, Model model){
        System.out.println("user ="+userCookie);
        model.addAttribute("customer" ,customerService.getCustomerByUsername(userCookie));
        return "editName";
    }

    @RequestMapping(value="/myDetails/editName", method = RequestMethod.POST)
    public String editNamePost(@Valid@ModelAttribute("user") Customer user, BindingResult result){
        if(result.hasErrors()){
            return "editName";
        }
        customerService.editCustomerDetails(user);
        return "redirect:/customer/myDetails/";
    }
    @RequestMapping(value="/myDetails/editPhone&Email")
    public String editPhoneEmail(@CookieValue("user") String userCookie, Model model){
        System.out.println("user ="+userCookie);
        model.addAttribute("customer" ,customerService.getCustomerByUsername(userCookie));
        return "editPhone&Email";
    }

    @RequestMapping(value="/myDetails/editPhone&Email", method = RequestMethod.POST)
    public String editPhoneEmailPost(@Valid@ModelAttribute("user") Customer user, BindingResult result){
        if(result.hasErrors()){
            return "editPhone&Email";
        }
        customerService.editCustomerDetails(user);
        return "redirect:/customer/myDetails/";
    }
    @RequestMapping(value="/myDetails/editPassword")
    public String editPassword(@CookieValue("user") String userCookie, Model model){
        System.out.println("user ="+userCookie);
        model.addAttribute("customer" ,customerService.getCustomerByUsername(userCookie));
        return "editPassword";
    }

    @RequestMapping(value="/myDetails/editPassword", method = RequestMethod.POST)
    public String editPasswordPost(@Valid@ModelAttribute("user") Customer user, BindingResult result){
        if(result.hasErrors()){
            return "editPassword";
        }
        customerService.editCustomerDetails(user);
        return "redirect:/customer/myDetails/";
    }

    @RequestMapping("/myOrders")
    public String getOrderDetails(@CookieValue("user") String userCookie, Model model){
        List<CustomerOrder> customerOrders = customerOrderService.getOrdersByCustomerId(customerService.getCustomerByUsername(userCookie).getCustomerId());
        model.addAttribute("orders", customerOrders);

        return "viewMyOrders";
    }

    @RequestMapping("/myAddresses")
    public String getUserAddresses(@CookieValue("user") String userCookie, Model model){
        model.addAttribute("user", customerService.getCustomerByUsername(userCookie));
        List<ShippingAddress> addresses= adrService.getCustomerSas(customerService.getCustomerByUsername(userCookie).getCustomerId());
        model.addAttribute("addresses", addresses);

        return "myAddresses";
    }

    @RequestMapping("/myAddresses/addAddress")
    public String addAddress(@CookieValue("user")String userCookie, Model model){
        ShippingAddress shippingAddress = new ShippingAddress();

        shippingAddress.setCustomer(customerService.getCustomerByUsername(userCookie));
        System.out.println(">>>>> controller, customerId in shippingAddress = "+ shippingAddress.getCustomer().getCustomerId());
        model.addAttribute("sadr", shippingAddress);

        return "addAddress";
    }

    @RequestMapping(value = "/myAddresses/addAddress", method = RequestMethod.POST)
    public String addAddressPost(@CookieValue("user")String userCookie, @Valid@ModelAttribute("sadr") ShippingAddress sadr){

        sadr.setCustomer(customerService.getCustomerByUsername(userCookie));
        adrService.addShippingAddress(sadr);
        return "redirect:/customer/myAddresses";
    }

    @RequestMapping("/myAddresses/editAddress/{saId}")
    public String editAddress(@PathVariable("saId") int saId,  Model model){
        ShippingAddress shippingAddress=adrService.getSa(saId);
        System.out.println(">>>>>>controller, saId: "+shippingAddress.getShippingAddressId());
        model.addAttribute("sadr", shippingAddress);

        return "editAddress";
    }

    @RequestMapping(value = "/myAddresses/editAddress", method = RequestMethod.POST)
    public String editAddressPost(@CookieValue("user")String userCookie, @Valid@ModelAttribute("sadr") ShippingAddress sadr, BindingResult result){
        if(result.hasErrors()){
            return "editAddress";
        }
        sadr.setCustomer(customerService.getCustomerByUsername(userCookie));
        System.out.println(">>>>>>controller, saId: "+sadr.getShippingAddressId());
        adrService.editShippingAddress(sadr);
        return "redirect:/customer/myAddresses";
    }
    @RequestMapping("/myAddresses/deleteAddress/{saId}")
    public String deleteAddress(@CookieValue("user")String userCookie, @PathVariable("saId") int saId, RedirectAttributes redirect){
        ShippingAddress sa=adrService.getSa(saId);
        adrService.deleteShippingAddress(sa);
        String msg="Address deleted successfully";

        if(!redirect.containsAttribute("addresses")){
            redirect.addFlashAttribute("refreshCO", adrService.getCustomerSas(customerService.getCustomerByUsername(userCookie).getCustomerId()));
            redirect.addFlashAttribute("msg", msg);
        }

        return "redirect:/customer/myAddresses";
    }

    @RequestMapping("/myAddresses/principalAddress/{saId}")
    public String principalAddress(@CookieValue("user")String userCookie, @PathVariable("saId") int saId, RedirectAttributes redirect){
        Customer customer=customerService.getCustomerByUsername(userCookie);
        ShippingAddress sa=adrService.getSa(saId);
        customer.setShippingAddress(sa);
        System.out.println(">>>>>> controller, customer saId: "+customer.getShippingAddress().getShippingAddressId());
        customerService.updateShAd(customer);
        String msg="Address set as primary successfully";

        if(!redirect.containsAttribute("addresses")){
            redirect.addFlashAttribute("refreshCO", adrService.getCustomerSas(customerService.getCustomerByUsername(userCookie).getCustomerId()));
            redirect.addFlashAttribute("msg", msg);
        }

        return "redirect:/customer/myAddresses";
    }
}
