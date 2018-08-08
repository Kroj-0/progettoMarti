package com.emusicstore.controller;


import com.emusicstore.model.BillingAddress;
import com.emusicstore.model.Customer;
import com.emusicstore.model.ShippingAddress;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MailService mailService;

    @RequestMapping("/register")
    public String registerCustomer(Model model){

        Customer customer=new Customer();

        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid@ModelAttribute("customer") Customer customer, Model model, BindingResult result){

        if(result.hasErrors()){
            return "registerCustomer";
        }

        List<Customer> customerList=customerService.getCustomerList();
        for(int i=0; i<customerList.size(); i++){
            if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())){
                model.addAttribute("emailMsg", "Email already registered");

                return "registerCustomer";
            }
            if(customer.getUsername().equals(customerList.get(i).getUsername())){
                model.addAttribute("usernameMsg", "Username already registered");
                return "registerCustomer";
            }
        }
        System.out.println(">>>>>I recieved password:"+customer.getPassword()+"/////");
        customer.setEnabled(true);
        customerService.addCustomer(customer);
        System.out.println(">>>>>sto per inviare la mail");
        String msg= "Welcome to WestEnd MusicStore, "+customer.getCustomerName()+"! You now have full access to our website, to purchase products" +
                ", manage your account and track your orders progress. Login now! ";
        mailService.sendEmail(customer.getCustomerEmail(), "order@wemusicstore.com", "Registration successful", msg);

        return "registerCustomerSuccess";
    }
}
