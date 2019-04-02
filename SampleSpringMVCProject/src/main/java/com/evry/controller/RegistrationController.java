package com.evry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evry.DTO.Registration;
import com.evry.service.RegistrationActivities;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationActivities registration_service;
	private  ModelAndView mav;

	
	// request handler "registrationPage" sends the registration page to the end user.
	 @RequestMapping(value="/register",method=RequestMethod.POST)
	  public String registrationPage(ModelMap model)
	  {
		  
		  return "registration";
		  
	  }
	 
	 
	 // this request handler passes the registration details entered by user to RegistrationActivities service
	 @RequestMapping(value="/registrationdetails", method=RequestMethod.POST)
	 public ModelAndView updateRegistrationDetails(@ModelAttribute Registration reg,ModelMap model)
	 {
		 
		System.out.println("control came to registratioin details method");
		 boolean flag=registration_service.addUser(reg);
		 
		 if(flag)
		 {
			 mav=new ModelAndView("registration_success");
			 mav.addObject("successmessage","Registration has been done successfully  . Plesae login ..");
			 return mav;
		 }
		 else {
			 mav=new ModelAndView("registration_failure");
			 mav.addObject("failuremessage","something went wrong with registration  . Plesae register again ..");
			 return mav;
		 }
	 }
}
