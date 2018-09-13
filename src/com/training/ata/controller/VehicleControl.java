package com.training.ata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.ata.bean.VehicleBean;
import com.training.ata.exception.ATAException;
import com.training.ata.service.Vehicle;

@Controller
public class VehicleControl 
{
	@Autowired
	Vehicle vehicleservice;
	@RequestMapping("/getvehicle")
	public ModelAndView getVehicle()
	{
		try
		{
			List <VehicleBean> vehicle = vehicleservice.getVehicle();
			ModelAndView mv = new ModelAndView("ViewVehicleAdmin", "vehicles",vehicle);
			return mv;
		}
		catch(ATAException e)
		{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
		
	}
	
	@RequestMapping(value="/addvehicle")
	public String addVehicle()
	{
		
		return "AddVehicle";
	}
	@RequestMapping(value="/savevehicle")
	public ModelAndView savevehicle(@ModelAttribute("vehicles") VehicleBean vehicle)
	{
		try {
			List<VehicleBean> vehicle1 = vehicleservice.addVehicle(vehicle);
			ModelAndView mv = new ModelAndView("ViewVehicleAdmin","vehicles",vehicle1);
			
			return mv;
		} catch (ATAException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	}
	@RequestMapping(value="/viewvehicle", method=RequestMethod.GET)
	public ModelAndView viewVehicle(VehicleBean vehicle)
	{
		try
		{
			List <VehicleBean> vehicle2 = vehicleservice.viewVehicle(vehicle);
			ModelAndView mv = new ModelAndView("ViewVehicle", "vehicle",vehicle2);
			return mv;
		}
		catch(ATAException e)
		{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
		
	}

}
