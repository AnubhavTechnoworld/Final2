package com.training.ata.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.ata.bean.ProfileBean;
import com.training.ata.exception.ATAException;
import com.training.ata.service.ProfileService;

@Controller
public class RegistrationController 
{
	@Autowired
	ProfileService profileservice;
	
	@RequestMapping("/getprofile")
	public ModelAndView getProfile()
	{
		try
		{
			List <ProfileBean> profile = profileservice.getProfile();
			ModelAndView mv = new ModelAndView("ViewProfile", "profiles",profile);
			return mv;
		}
		catch(ATAException e)
		{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	}
	
	@RequestMapping("/addprofile")
	public String addProfile()
	{
		return "registration";
	}
	
	@RequestMapping(value="/saveprofile",method=RequestMethod.POST)
	public ModelAndView saveprofile(@ModelAttribute("profiles") ProfileBean profile,@RequestParam("dob") String dob)
	{
		try {
			Date d=Date.valueOf(dob);	
			profile.setDateOfBirth(d);
		
			List<ProfileBean> profile1 = profileservice.addProfile(profile);
			ModelAndView mv = new ModelAndView("ViewProfile","profiles",profile1);
			
			return mv;
		} catch (ATAException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error",e);
			return mv;
		}
	}

}
