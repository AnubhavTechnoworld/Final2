package com.training.ata.dao;

import java.util.List;

import com.training.ata.bean.RouteBean;
import com.training.ata.exception.ATAException;

public interface RouteBeanDAO 
{
	
	public List<RouteBean> getRoutes() throws ATAException;
	public List<RouteBean> addRoutes(RouteBean route) throws ATAException;

}
