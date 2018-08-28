package com.emusicstore.service.impl;

import com.emusicstore.dao.UsersDao;
import com.emusicstore.model.Users;
import com.emusicstore.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    public Users getUserByUsername(String username) {
        return usersDao.getUserByUsername(username);
    }

    public void setEnable(Users user) {
        usersDao.setEnable(user);
    }
}
