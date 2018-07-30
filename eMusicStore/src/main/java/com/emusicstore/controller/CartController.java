package com.emusicstore.controller;


import com.emusicstore.model.Customer;
import com.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("cartIdRefresh")
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

    //@AuthenticationPrincipal prende l'utente logato e ne prende le info
    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser, RedirectAttributes redirect){
        System.out.println(">>>>>>>>>>>>>>>>> sono dentro");

        Customer customer=customerService.getCustomerByUsername(activeUser.getUsername());
        System.out.println(">>>>>>>>>>>>>>>>> dovrei avere customer "+ customer.getUsername());
        int cartId=customer.getCart().getCartId();
        if(!redirect.containsAttribute("cartIdRefresh")){
            redirect.addFlashAttribute("cartIdRefresh", cartId);
        }

        return "redirect:/customer/cart/myCart" ;
    }

    @RequestMapping("/myCart")
    public String getCartRedirect(Model model, @ModelAttribute("cartIdRefresh") Object cartId){
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}
