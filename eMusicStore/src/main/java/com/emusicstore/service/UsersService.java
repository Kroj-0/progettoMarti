package com.emusicstore.service;

import com.emusicstore.model.Users;

public interface UsersService {
    Users getUserByUsername(String username);
    void setEnable(Users user);
}
