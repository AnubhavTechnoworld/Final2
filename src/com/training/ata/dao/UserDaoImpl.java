package com.training.ata.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.ata.bean.CredentialsBean;


@Repository
public class UserDaoImpl implements UserDao

{

 
		@Autowired
	   SessionFactory sessionFactory;

   
 

   

    @Override

    public boolean isValidUser(String user, String password) throws SQLException

    {

        /*String query = "Select count(1) from Login where user = ? and password = ?";

        PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);

        pstmt.setString(1, user);

        pstmt.setString(2, password);

        ResultSet resultSet = pstmt.executeQuery();*/
    	System.out.println("=========="+user);
    	Session session=sessionFactory.openSession();
    	CredentialsBean cb=session.get(CredentialsBean.class, user);
    	System.out.println(cb);
    	if(cb==null) {
    		return false;
    	}
    	else if(cb.getPassword().equals(password)) {
    		return true;
    	}
    	else {
    		return false;
    	}

       /* if(resultSet.next())

            return (resultSet.getInt(1) > 0);

        else

           return false;

       }*/

 
    }
}

