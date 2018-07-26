package com.emusicstore.controller;

import com.emusicstore.model.Product;
import com.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;
    @RequestMapping
    public  String adminPage(){
        return "admin";
    }
    @RequestMapping("/productInventory")
    public String productInventory(Model model){

        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "productInventory";
    }

    @RequestMapping("/customer")
    public  String customerManagement(Model model){

        //to do
        return "customerManagement";
    }
}