package com.training.ata.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.ata.bean.DriverBean;
import com.training.ata.exception.ATAException;

@Repository
public class DriverBeanDAOImpl implements DriverBeanDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<DriverBean> getDriver() throws ATAException {
		try
		{
			Session session = sessionFactory.openSession();
			Query query =session.createQuery("from DriverBean");
			List<DriverBean> driver =query.list();
			session.close();
			return driver;
		}
		catch(Exception ex)
		{
			throw new ATAException(ex.getMessage());
		}
	}

	@Override
	public List<DriverBean> addDriver(DriverBean driver) throws ATAException {
		try
		{			

			Session session = sessionFactory.openSession();
			String userName = driver.getName().substring(0, 2).toUpperCase();
			Query q=session.createSQLQuery("select ata_seq_driverId.nextval from dual");
			BigDecimal b=(BigDecimal) q.uniqueResult();
			String driverID=userName+String.valueOf(b);
			session.beginTransaction();
			driver.setDriverID(driverID);
			session.persist(driver);
			session.getTransaction().commit();
			return getDriver();
		}
		catch(Exception ex)
		{
			throw new ATAException(ex.getMessage());
		}
	}


}
