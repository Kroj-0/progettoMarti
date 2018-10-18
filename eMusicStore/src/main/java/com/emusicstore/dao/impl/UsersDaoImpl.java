package com.emusicstore.dao.impl;

import com.emusicstore.dao.UsersDao;
import com.emusicstore.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        Query query=session.createQuery("update Users set enabled=? where userId=?");
        query.setBoolean(0, user.isEnabled());
        query.setInteger(1, user.getUserId());
        query.executeUpdate();
        session.flush();
        //        user.setEnabled(user.isEnabled());
//        session.saveOrUpdate(user);
//        session.flush();
//        System.out.println(">>>>>>>>DAO>>>>>>>>dopo della modifica "+ user.isEnabled());
//
        Users control=getUserByUsername(user.getUsername());
        System.out.println(">>>>>>>>DAO>>>>>>>>dopo della modifica controllo il db "+ control.isEnabled());
        session.flush();
    }
}
