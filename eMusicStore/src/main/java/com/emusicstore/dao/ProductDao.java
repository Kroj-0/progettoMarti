package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.List;


public interface ProductDao {

    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    List<Product> getPromoProducts();

    List<Product> getProductsFromSearch(String name, String order);

    List<Product> getProductsFromCategory(String name, String order);

    List<Product> getProductsFromSubcategory(String name, String order);

    void deleteProduct(int id);
}
