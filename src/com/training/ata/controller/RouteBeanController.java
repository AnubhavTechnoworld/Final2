package com.training.ata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.ata.bean.RouteBean;
import com.training.ata.exception.ATAException;
import com.training.ata.service.RouteService;

@Controller
public class RouteBeanController 
{
	@Autowired
	RouteService routeservice;
	@RequestMapping("/getroute")
	public ModelAndView getRoute()
	{
		try
		{
			List <RouteBean> route = routeservice.getRoutes();
			ModelAndView mv = new ModelAndView("ViewRoute", "route",route);
			return mv;
		}
		catch(ATAException e)
		{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	}
	
	@RequestMapping(value="/addroute")
	public String addRoutes()
	{
		
		return "addRoute";
	}
	
	@RequestMapping("/saveroute")
	public ModelAndView savevehicle(@ModelAttribute("routes") RouteBean route)
	{
		try {
			List<RouteBean> route1 = routeservice.addRoutes(route);
			ModelAndView mv = new ModelAndView("ViewRoute", "route",route1);
			
			return mv;
		} catch (ATAException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	}
	@RequestMapping(value="/viewroute",method=RequestMethod.GET)
	public ModelAndView viewvehicle(RouteBean route)
	{
		try {
			List<RouteBean> route2 = routeservice.viewRoutes(route);
			ModelAndView mv = new ModelAndView("ViewRouteCustomer", "route",route2);
			
			return mv;
		} catch (ATAException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	}
}
