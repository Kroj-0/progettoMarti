package com.emusicstore.dao;

import com.emusicstore.model.Users;

public interface UsersDao {

    Users getUserByUsername(String username);
    void setEnable(Users user);

}
