package com.training.ata.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.ata.bean.RouteBean;
import com.training.ata.exception.ATAException;

@Repository
public class RouteBeanDAOImpl implements RouteBeanDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<RouteBean> getRoutes() throws ATAException {
		
		try
		{
		Session session = sessionFactory.openSession();
		Query query =session.createQuery("from RouteBean");
		List<RouteBean> routes = query.list();
		session.close();
		return routes;
		}
		catch(Exception ex)
		{
			throw new ATAException(ex.getMessage());
		}
	}

	@Override
	public List<RouteBean> addRoutes(RouteBean route) throws ATAException {
		try
		{
			Session session = sessionFactory.openSession();
			String userName = route.getSource().substring(0, 2).toUpperCase();
			Query q=session.createSQLQuery("select ata_seq_routeid.nextval from dual");
			BigDecimal b=(BigDecimal) q.uniqueResult();
			String routeID=userName+String.valueOf(b);
			session.beginTransaction();
			route.setRouteID(routeID);
			session.persist(route);
			session.getTransaction().commit();
			return getRoutes();
		}
		catch(Exception ex)
		{
			throw new ATAException(ex.getMessage());
		}
	}
	

}
