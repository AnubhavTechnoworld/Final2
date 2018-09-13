package com.training.ata.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ata.dao.UserDao;



@Service

public class UserServiceImpl implements UserService

{

 

	@Autowired
    private UserDao userDao;

 
    public UserDao getUserDao()


    {

        return this.userDao;

    }


    public void setUserDao(UserDao userDao)

    {

        this.userDao = userDao;

    }


    @Override

    public boolean isValidUser(String user, String password) throws SQLException

    {

        return userDao.isValidUser(user, password);

    }

 

}
