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

    public void editEnable(Customer customer) {
        //aggiorno customer dalla form
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();


        System.out.println(">>>>>>>>>>>>>>>>>>prendo l'user corrispondente al customer attraverso il customerId");
        Query query=session.createQuery("from Users where customerId = ?");
        query.setInteger(0, customer.getCustomerId());
        Users users= (Users)query.uniqueResult();
        System.out.println(">>>>>>>>>>>>>> " + users.getUserId() + users.getUsername() + users.isEnabled() + users.getCustomerId());
        users.setEnabled(customer.isEnabled());
        System.out.println(">>>>>>>>>>>>>> " + users.getUserId() + users.getUsername() + users.isEnabled() + users.getCustomerId());
        System.out.println(">>>>>>>>>>>>>>>>>>aggiorno la tabella users");
        session.saveOrUpdate(users);
        session.flush();

    }

    public void editCustomerDetails(Customer customer) {
        Session session=sessionFactory.getCurrentSession();
        session.update(customer);
        session.flush();
        Query query=session.createQuery("from Users where customerId = ?");
        query.setInteger(0, customer.getCustomerId());
        Users users= (Users)query.uniqueResult();
        System.out.println(">>>>>>>>>>>>>> " + users.getUserId() + users.getUsername() + users.isEnabled() + users.getCustomerId());
        users.setPassword(customer.getPassword());
        System.out.println(">>>>>>>>>>>>>> " + users.getUserId() + users.getUsername() + users.isEnabled() + users.getCustomerId());
        System.out.println(">>>>>>>>>>>>>>>>>>aggiorno la tabella users");
        session.saveOrUpdate(users);
        session.flush();
        Query query1=session.createQuery("from Authorities where username = ?");
        query1.setString(0, customer.getUsername());
        Authorities authorities= (Authorities) query1.uniqueResult();
        authorities.setPassword(customer.getPassword());
        session.saveOrUpdate(authorities);
        session.flush();
    }

    public void updateShAd(Customer customer){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();
    }

    public String getPwd(String username) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer where username = ?");
        query.setString(0, username);

        String pwd=query.uniqueResult().toString();
        session.flush();
        return pwd;
    }
}
