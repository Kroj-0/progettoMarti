package com.emusicstore.dao.impl;


import com.emusicstore.dao.CustomerDao;
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

        Users newUser = new Users();

        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);
        customer.setUsers(newUser);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

//        Authorities newAuthority=new Authorities();
//        newAuthority.setUsername(customer.getUsername());
//        newAuthority.setAuthority("ROLE_USER");
//        newAuthority.setPassword(customer.getPassword());
//        session.saveOrUpdate(newAuthority);

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
        //Siccome username è unico, il risultato sara univoco: posso castare la query a oggetto customer con uniqueResult()
    }

    public void editEnable(Customer customer) {
        //aggiorno customer dalla form
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();


        System.out.println(">>>>>>>>>>>>>>>>>>prendo l'user corrispondente al customer attraverso il customerId");
        Query query=session.createQuery("from Users where userId = ?");
        query.setInteger(0, customer.getUsers().getUserId());
        Users users= (Users)query.uniqueResult();
//        System.out.println(">>>>>>>>>>>>>> " +  users.getUsername() + users.isEnabled() + users.getCustomerId());
        users.setEnabled(!users.isEnabled());
//        System.out.println(">>>>>>>>>>>>>> " +  users.getUsername() + users.isEnabled() + users.getCustomerId());
        System.out.println(">>>>>>>>>>>>>>>>>>aggiorno la tabella users");
        session.saveOrUpdate(users);
        session.flush();

    }

    public void editCustomerDetails(Customer customer) {
        Session session=sessionFactory.getCurrentSession();

//        Query query=session.createQuery(" from Users where userId = ?");
//        query.setInteger(0, customer.getUsers().getUserId());
//        Users users= (Users)query.uniqueResult();
//        System.out.println(">>>>>>>>> userId, enabled, pwd, username and authority : "+ users.getUserId() + " "
//                + users.isEnabled() + " " + users.getPassword() + " "+ users.getUsername() + " " + users.getAuthority());
//        System.out.println(">>>>>>>>>>>>>> " + users.getUserId() + users.getUsername() + users.isEnabled() + users.getCustomer().getCustomerId());
//        users.setPassword(customer.getPassword());
//        System.out.println(">>>>>>>>> userId, enabled, newpwd, username and authority : "+ users.getUserId() + " "
//                + users.isEnabled() + " " + users.getPassword() + " "+ users.getUsername() + " " + users.getAuthority());
//        System.out.println(">>>>>>>>>>>>>> " + users.getUserId() + users.getUsername() + users.isEnabled() + users.getCustomer().getCustomerId());
        customer.getUsers().setPassword(customer.getPassword());
        System.out.println(">>>>>>>>>>>>>>>>>>aggiorno la tabella users");
        session.merge(customer.getUsers());
//        session.flush();
//        session.clear();
        System.out.println(">>>>>>>>>>>>>>>>>>aggiorno la tabella customer");
        session.merge(customer);
        session.flush();
        System.out.println(">>>>>>>>>>>>>>>>>>ho finito, non devo piu tornare qui");

    }

    public void updateShAd(Customer customer){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();
    }

    public String getPwd(String username) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Users where username = ?");
        query.setString(0, username);

        String pwd=query.uniqueResult().toString();
        session.flush();
        return pwd;
    }

    public Customer getCustomerByEmail(String email) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer where customerEmail=?");
        query.setString(0, email);

        Customer customer=(Customer)query.uniqueResult();
        session.flush();
        return customer;
    }
}
