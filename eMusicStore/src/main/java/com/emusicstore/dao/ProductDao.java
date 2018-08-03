package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.List;


public interface ProductDao {

    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    List<Product> getProductsFromSearch(String name);

    List<Product> getProductsFromCategory(String name);

    List<Product> getProductsFromSubcategory(String name);

    void deleteProduct(int id);
}
