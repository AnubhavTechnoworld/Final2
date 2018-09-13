package com.training.ata.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.training.ata.exception.ATAException;


public class DBUtil {
	
	public static Connection getConnection() throws ATAException
	{
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url, "hr", "hr");
		}
		catch (ClassNotFoundException e) 
		{
			throw new ATAException(e.getMessage());
		} catch (SQLException e) {
			throw new ATAException(e.getMessage());
		}
	}

}
