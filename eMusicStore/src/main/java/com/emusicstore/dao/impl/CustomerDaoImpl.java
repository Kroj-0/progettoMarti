package com.emusicstore.dao.impl;


import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Authorities;
import com.emusicstore.model.Cart;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer){

        Session session=sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();

        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority=new Authorities();

        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");
        newAuthority.setPassword(customer.getPassword());

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        //forse rivedibile. Conviene assegnare al cliente un cart alla registrazione o quando effettivamente vuole
        //mettere qualcosa nel carrello??
        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerById(int customerId){

        Session session=sessionFactory.getCurrentSession();
        return(Customer) session.get(Customer.class, customerId);
    }

    public List<Customer> getCustomerList(){

        Session session=sessionFactory.getCurrentSession();

        Query query=session.createQuery("from Customer");
        List<Customer> customerList=query.list();

        return customerList;
    }
    public Customer getCustomerByUsername(String username){

        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer where username = ?");
        query.setString(0, username);

        return (Customer) query.uniqueResult();

        // attraverso '?' indico una variabile, con setString associo alla prima occorrenza di ? lo username passato come parametro
        //Siccome username è chiave primaria, il risultato sara univoco: posso castare la query a oggetto customer con uniqueResult()
    }
}
