package com.evry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evry.DTO.Registration;
import com.evry.service.RegistrationActivities;

@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationActivities registration_service;

	
	 @RequestMapping(value="/register",method=RequestMethod.POST)
	  public String loginVerify(ModelMap model)
	  {
		  
		  return "registration";
		  
	  }
	 
	 @RequestMapping(value="/registrationdetails", method=RequestMethod.POST)
	 public void updateRegistrationDetails(@ModelAttribute Registration reg,ModelMap Model)
	 {
		 System.out.println("control came to registratioin details method");
		 registration_service.addUser(reg);
	 }
}
