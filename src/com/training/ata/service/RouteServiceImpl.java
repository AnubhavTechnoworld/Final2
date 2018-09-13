package com.training.ata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.ata.bean.RouteBean;
import com.training.ata.dao.RouteBeanDAO;
import com.training.ata.exception.ATAException;

@Service
@Transactional
public class RouteServiceImpl implements RouteService 
{

	@Autowired
	RouteBeanDAO routeDAO;
	
	@Override
	public List<RouteBean> getRoutes() throws ATAException {
		return routeDAO.getRoutes();
	}

	@Override
	public List<RouteBean> addRoutes(RouteBean route) throws ATAException {
		return routeDAO.addRoutes(route);
	}

	@Override
	public List<RouteBean> viewRoutes(RouteBean route) throws ATAException {
		// TODO Auto-generated method stub
		return getRoutes();
	}

}
