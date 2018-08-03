package com.emusicstore.service;

import com.emusicstore.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product> getProductsFromSearch(String name);
    List<Product> getProductsFromCategory(String name);
    List<Product> getProductsFromSubcategory(String name);
    Product getProductById(int id);
    void addProduct(Product product);
    void editProduct(Product product);
    void deleteProduct(Product product);
}
