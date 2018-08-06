package com.emusicstore.dao.impl;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    public List<Product> getProductsFromSearch(String name, String order) {
        Session session=sessionFactory.getCurrentSession();
        if(order==null){
            Query query=session.createQuery("from Product where productName like ? or productDescription like ? or productSubcategory like ? or productCategory like ?");
            query.setString(0, "%"+name+"%");
            query.setString(1, "%"+name+"%");
            query.setString(2, "%"+name+"%");
            query.setString(3, "%"+name+"%");

            List<Product> products=query.list();
            session.flush();
            return products;
        }
        else{
            String [] values=order.split("_");

            Query query=session.createQuery("from Product where productName like ? or " +
                    "productDescription like ? or productSubcategory like ? or productCategory like ? order by "+ values[0]+" "+ values[1]);
            query.setString(0, "%"+name+"%");
            query.setString(1, "%"+name+"%");
            query.setString(2, "%"+name+"%");
            query.setString(3, "%"+name+"%");


            List<Product> products=query.list();
            session.flush();
            return products;

        }

    }

    public List<Product> getProductsFromCategory(String name, String order) {
        Session session=sessionFactory.getCurrentSession();
        if(order==null){
            Query query=session.createQuery("from Product where productCategory like ?");
            query.setString(0,"%"+name+"%");

            List<Product> products=query.list();
            session.flush();
            return products;
        }
        else{
            String [] values=order.split("_");
            Query query=session.createQuery("from Product where productCategory like ? order by "+ values[0]+" "+ values[1]);
            query.setString(0,"%"+name+"%");

            List<Product> products=query.list();
            session.flush();
            return products;
        }

    }
    public List<Product> getProductsFromSubcategory(String name, String order) {
        Session session=sessionFactory.getCurrentSession();
        if(order==null){
            Query query=session.createQuery("from Product where productSubcategory like ?");
            query.setString(0,"%"+name+"%");

            List<Product> products=query.list();
            session.flush();
            return products;
        }
        else{
            String [] values=order.split("_");
            Query query=session.createQuery("from Product where productSubcategory like ? order by "+ values[0]+" "+ values[1]);
            query.setString(0,"%"+name+"%");

            List<Product> products=query.list();
            session.flush();
            return products;
        }
    }

    public void deleteProduct (int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();
    }

    public List<Product> getPromoProducts() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Product where ProductCondition like ?");
        query.setString(0, "%promo%");

        List<Product> products=query.list();
        session.flush();
        return products;
    }
}
