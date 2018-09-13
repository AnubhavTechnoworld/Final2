package com.training.ata.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.ata.bean.VehicleBean;
import com.training.ata.exception.ATAException;

@Repository
public class VehicleBeanDAOImpl implements VehicleBeanDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<VehicleBean> getVehicle() throws ATAException 
	{
		try
		{
			Session session = sessionFactory.openSession();
			Query query =session.createQuery("from VehicleBean");
			List<VehicleBean> vehicle =query.list();
			session.close();
			return vehicle;
		}
		catch(Exception ex)
		{
			throw new ATAException(ex.getMessage());
		}
	}

	@Override
	public List<VehicleBean> addVehicle(VehicleBean vehicle) throws ATAException {
		try
		{
			
			Session session = sessionFactory.openSession();
			String userName = vehicle.getName().substring(0, 2).toUpperCase();
			Query q=session.createSQLQuery("select ata_seq_vehicleId.nextval from dual");
			BigDecimal b=(BigDecimal) q.uniqueResult();
			String vehicleID=userName+String.valueOf(b);
			session.beginTransaction();
			vehicle.setVehicleID(vehicleID);
			session.persist(vehicle);
			session.getTransaction().commit();
			return getVehicle();
		}
		catch(Exception ex)
		{
			throw new ATAException(ex.getMessage());
		}
	}
	
	
}

