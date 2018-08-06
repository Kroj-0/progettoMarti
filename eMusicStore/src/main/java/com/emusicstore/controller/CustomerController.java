package com.emusicstore.controller;


import com.emusicstore.model.*;
import com.emusicstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private TrackingService trackingService;

    @RequestMapping
    public String customerPage(){
        return "customer";
    }

    @RequestMapping("/myDetails")
    public String getUserDetails(Model model, @AuthenticationPrincipal User activeUser){

        Customer customer=customerService.getCustomerByUsername(activeUser.getUsername());
        model.addAttribute("user", customer);
        return "viewMyDetail";
    }

    @RequestMapping(value="/myDetails/editName")
    public String editName(Model model, @AuthenticationPrincipal User activeUser){

        model.addAttribute("customer" ,customerService.getCustomerByUsername(activeUser.getUsername()));
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
    public String editPhoneEmail(Model model, @AuthenticationPrincipal User activeUser){

        model.addAttribute("customer" ,customerService.getCustomerByUsername(activeUser.getUsername()));
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
    public String editPassword(Model model, @AuthenticationPrincipal User activeUser){

        model.addAttribute("customer" ,customerService.getCustomerByUsername(activeUser.getUsername()));
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
    public String getOrderDetails(Model model, @AuthenticationPrincipal User activeUser){

        List<CustomerOrder> customerOrders = customerOrderService.getOrdersByCustomerId(customerService.getCustomerByUsername(activeUser.getUsername()).getCustomerId());
        model.addAttribute("orders", customerOrders);

        return "viewMyOrders";
    }

    @RequestMapping("/myOrders/tracking/{trackingId}")
    public String viewTracking(@PathVariable("trackingId") String trackingId, Model model){

        CustomerOrder customerOrder=customerOrderService.getFromTracking(trackingId);
        System.out.println(">>>>>preso il customer dal trackId");
        List<Tracking> tracking=trackingService.getTrackingById(trackingId);
        System.out.println(">>>>>presa la lista degli stati tracking dal trackId");
        System.out.println(">>>>>prrimo elemento data: "+tracking.get(0).getDate());
        Map<String, String> status = new HashMap<String, String>();
        status.put("confirmed", "confirmed");
        status.put("prep4shipping", "prepaired");
        status.put("shipped", "shipped");
        status.put("transit", "transit");
        status.put("received", "received");
        status.put("cancelled", "cancelled");
        model.addAttribute("status", status);
        model.addAttribute("trackingHst", tracking);
        model.addAttribute("order", customerOrder);

        return "tracking";
    }

    @RequestMapping("/myAddresses")
    public String getUserAddresses(Model model, @AuthenticationPrincipal User activeUser){

        model.addAttribute("user", customerService.getCustomerByUsername(activeUser.getUsername()));
        List<ShippingAddress> addresses= adrService.getCustomerSas(customerService.getCustomerByUsername(activeUser.getUsername()).getCustomerId());
        model.addAttribute("addresses", addresses);

        return "myAddresses";
    }

    @RequestMapping("/myAddresses/addAddress")
    public String addAddress(Model model, @AuthenticationPrincipal User activeUser){
        ShippingAddress shippingAddress = new ShippingAddress();

        shippingAddress.setCustomer(customerService.getCustomerByUsername(activeUser.getUsername()));
        System.out.println(">>>>> controller, customerId in shippingAddress = "+ shippingAddress.getCustomer().getCustomerId());
        model.addAttribute("sadr", shippingAddress);

        return "addAddress";
    }

    @RequestMapping(value = "/myAddresses/addAddress", method = RequestMethod.POST)
    public String addAddressPost(@Valid@ModelAttribute("sadr") ShippingAddress sadr, @AuthenticationPrincipal User activeUser){

        sadr.setCustomer(customerService.getCustomerByUsername(activeUser.getUsername()));
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
    public String editAddressPost(@Valid@ModelAttribute("sadr") ShippingAddress sadr, BindingResult result, @AuthenticationPrincipal User activeUser){
        if(result.hasErrors()){
            return "editAddress";
        }

        sadr.setCustomer(customerService.getCustomerByUsername(activeUser.getUsername()));
        System.out.println(">>>>>>controller, saId: "+sadr.getShippingAddressId());
        adrService.editShippingAddress(sadr);
        return "redirect:/customer/myAddresses";
    }
    @RequestMapping("/myAddresses/deleteAddress/{saId}")
    public String deleteAddress(@PathVariable("saId") int saId, RedirectAttributes redirect, @AuthenticationPrincipal User activeUser){

        ShippingAddress sa=adrService.getSa(saId);
        adrService.deleteShippingAddress(sa);
        String msg="Address deleted successfully";

        if(!redirect.containsAttribute("addresses")){
            redirect.addFlashAttribute("refreshCO", adrService.getCustomerSas(customerService.getCustomerByUsername(activeUser.getUsername()).getCustomerId()));
            redirect.addFlashAttribute("msg", msg);
        }

        return "redirect:/customer/myAddresses";
    }

    @RequestMapping("/myAddresses/principalAddress/{saId}")
    public String principalAddress(@PathVariable("saId") int saId, RedirectAttributes redirect, @AuthenticationPrincipal User activeUser){

        Customer customer=customerService.getCustomerByUsername(activeUser.getUsername());
        ShippingAddress sa=adrService.getSa(saId);
        customer.setShippingAddress(sa);
        System.out.println(">>>>>> controller, customer saId: "+customer.getShippingAddress().getShippingAddressId());
        customerService.updateShAd(customer);
        String msg="Address was successfully set as principal!";

        if(!redirect.containsAttribute("addresses")){
            redirect.addFlashAttribute("refreshCO", adrService.getCustomerSas(customerService.getCustomerByUsername(activeUser.getUsername()).getCustomerId()));
            redirect.addFlashAttribute("msg", msg);
        }

        return "redirect:/customer/myAddresses";
    }
}
