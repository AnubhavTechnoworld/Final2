package com.training.ata.service;


import java.util.List;

import com.training.ata.bean.RouteBean;
import com.training.ata.exception.ATAException;

public interface RouteService 
{
	public List<RouteBean> getRoutes() throws ATAException;
	public List<RouteBean> addRoutes(RouteBean route) throws ATAException;
	public List<RouteBean> viewRoutes(RouteBean route) throws ATAException;
}
