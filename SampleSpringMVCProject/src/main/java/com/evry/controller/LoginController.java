package com.evry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evry.DTO.Login;
import com.evry.service.LoginActivities;

@Controller
public class LoginController {

	@Autowired
	private LoginActivities login_service;
	private  ModelAndView mav;
	
	
	//Request handler "loginpage" returns the Login page to user as soon as website is accessed
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	 public String loginPage(ModelMap model) {
		  
		 return "login";
	    }
	  
	  
	  //Request  handler "loginVerify" passed  the control to the "verifyLogin" method of LoginActivities service
	  @RequestMapping(value="/loginverify",method=RequestMethod.POST)
	  public ModelAndView  loginVerify(@ModelAttribute Login logincred,ModelMap model)
	  {
		  
		  System.out.println(logincred.getUsername());
		  System.out.println(logincred.getPassword());
		  boolean flag=login_service.verifyLogin(logincred);
		  
		  if(flag)
			 {
				 mav=new ModelAndView("login_success");
				 mav.addObject("successmessage","Welcome to the Fastest Paytm ..");
				 mav.addObject("logindetails", logincred);
				 return mav;
				 
			 }
			 else {
				 mav=new ModelAndView("login_failure");
				 mav.addObject("failuremessage","UserName or Password entered are incorrect...Plesae verify and try again.");
				 return mav;
			 }
		  
	  }
	
}
