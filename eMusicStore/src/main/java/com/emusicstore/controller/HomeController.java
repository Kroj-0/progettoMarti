package com.emusicstore.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
        required = false) String logout, Model model){
        if(error!=null){
            model.addAttribute("error", "Invalid username and password");
        }
        if(logout!=null){
            model.addAttribute("msg", "Logged out succesfully");
        }
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(">>>>> user ");
        return "login";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }
}
