package com.emusicstore.controller;

import com.emusicstore.model.Product;
import com.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/promo")
    public String promoProducts(Model model){
        List<Product> products=productService.getPromoProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/categories")
    public String getCategories(){
        return "categories";
    }

    @RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
    public String searchProducts (@RequestParam("search") String productName,
                                  @RequestParam(value = "order", required = false) String order, Model model){
        List<Product> products=productService.getProductsFromSearch(productName, order);
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping(value = "/cat", method = RequestMethod.GET)
    public String getProductsByCategory(@RequestParam("category") String category,
                                        @RequestParam(value = "order", required = false) String order, Model model){
        List<Product> products=productService.getProductsFromCategory(category, order);
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping(value = "/subcat", method = RequestMethod.GET)
    public String getProductsBySubcategory(@RequestParam("subcategory") String subcategory,
                                           @RequestParam(value = "order", required = false) String order, Model model){
        List<Product> products=productService.getProductsFromSubcategory(subcategory, order);
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable("productId") int productId, Model model) throws IOException{

        Product product=productService.getProductById(productId);
        model.addAttribute(product);

        return "viewProduct";
    }
}
