package com.emusicstore.service.impl;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import com.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    public void addProduct(Product product){
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product.getProductId());
    }

    public List<Product> getProductsFromSearch(String name) {
        return productDao.getProductsFromSearch(name);
    }

    public List<Product> getProductsFromCategory(String name) {
        return productDao.getProductsFromCategory(name);
    }

    public List<Product> getProductsFromSubcategory(String name) {
        return productDao.getProductsFromSubcategory(name);
    }
}
