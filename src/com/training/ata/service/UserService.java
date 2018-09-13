package com.training.ata.service;

import java.sql.SQLException;


public interface UserService

{

    public default boolean isValidUser(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
 