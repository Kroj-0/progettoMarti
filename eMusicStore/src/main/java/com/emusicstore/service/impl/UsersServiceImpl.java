package com.emusicstore.service.impl;

import com.emusicstore.dao.UsersDao;
import com.emusicstore.model.Users;
import com.emusicstore.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    public Users getUserByUsername(String username) {
        return usersDao.getUserByUsername(username);
    }

    public void setEnable(Users user) {

        Users control= usersDao.getUserByUsername(user.getUsername());
        System.out.println(">>>>>>>>SERVICE>>>>>>>>prima della modifica controllo il db "+ control.isEnabled());
        usersDao.setEnable(user);
    }
}
