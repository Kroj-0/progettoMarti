package com.emusicstore.dao.impl;

import com.emusicstore.dao.UsersDao;
import com.emusicstore.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Users getUserByUsername(String username) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Users where username = ?");
        query.setString(0, username);

        Users user= (Users)query.uniqueResult();
        session.flush();
        return user;
    }

    public void setEnable(Users user) {
        Session session=sessionFactory.getCurrentSession();
        user.setEnabled(!user.isEnabled());
        session.saveOrUpdate(user);
        session.flush();
    }
}
