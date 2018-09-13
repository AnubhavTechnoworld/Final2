package com.training.ata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.ata.bean.DriverBean;
import com.training.ata.bean.VehicleBean;
import com.training.ata.exception.ATAException;
import com.training.ata.service.DriverService;

@Controller
public class DriverController
{
	@Autowired
	DriverService driverservice;
	
	@RequestMapping("/getdriver")
	public ModelAndView getDriver()
	{
		try
		{
			List <DriverBean> driver = driverservice.getDriver();
			ModelAndView mv = new ModelAndView("ViewDriver", "drivers",driver);
			return mv;
		}
		catch(ATAException e)
		{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
		
	}
	
	@RequestMapping(value="/adddriver")
	public String addDriver()
	{
		
		return "AddDriver";
	}
	
	@RequestMapping(value="/savedriver")
	public ModelAndView savedriver(@ModelAttribute("drivers") DriverBean driver)
	{
		try {
			List<DriverBean> driver1 = driverservice.addDriver(driver);
			ModelAndView mv = new ModelAndView("ViewDriver","drivers",driver1);
			
			return mv;
		} catch (ATAException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	}
}
