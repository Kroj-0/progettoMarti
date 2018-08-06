package com.emusicstore.service;

import com.emusicstore.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product> getProductsFromSearch(String name, String order);
    List<Product> getProductsFromCategory(String name, String order);
    List<Product> getProductsFromSubcategory(String name, String order);
    Product getProductById(int id);
    void addProduct(Product product);
    void editProduct(Product product);
    void deleteProduct(Product product);
    List<Product> getPromoProducts();
}
