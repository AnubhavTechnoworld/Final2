package com.training.ata.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.ata.bean.CredentialsBean;
import com.training.ata.bean.ProfileBean;
import com.training.ata.exception.ATAException;

@Repository
public class ProfileBeanDAOImpl implements ProfileBeanDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<ProfileBean> getProfile() throws ATAException {
		try
		{
			Session session = sessionFactory.openSession();
			Query query =session.createQuery("from ProfileBean");
			List<ProfileBean> profile =query.list();
			session.close();
			return profile;
		}
		catch(Exception ex)
		{
			throw new ATAException(ex.getMessage());
		}
	}

	@Override
	public List<ProfileBean> addProfile(ProfileBean profile) throws ATAException {
		try
		{			
			

			Session session = sessionFactory.openSession();
			String userName = profile.getFirstName().substring(0, 2).toUpperCase();
			Query q=session.createSQLQuery("select ata_seq_userID.nextval from dual");
			BigDecimal b=(BigDecimal) q.uniqueResult();
			String userID=userName+String.valueOf(b);
			
			CredentialsBean cb=new CredentialsBean();

			
			cb.setUserID(userID);
			cb.setLoginStatus(0);
			cb.setPassword(profile.getPassword());		
			cb.setUsertype("C");
			
			session.beginTransaction();
			session.persist(cb);
			session.getTransaction().commit();
			session.beginTransaction();
			profile.setUserID(userID);
			session.persist(profile);
			session.getTransaction().commit();
			return getProfile();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new ATAException(ex.getMessage());
		}
	}
	
	
}
