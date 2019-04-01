package com.evry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evry.DTO.Login;

@Controller
public class LoginController {

	
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  
	    public String loginPage(ModelMap model) {
		  
		  System.out.println("control is entered into loginverify method");
	        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
	        return "login";
	    }
	  
	  @RequestMapping(value="/loginverify",method=RequestMethod.POST)
	  public void loginVerify(@ModelAttribute Login logincred,ModelMap model)
	  {
		  
		  System.out.println(logincred.getUsername());
		  System.out.println(logincred.getPassword());
		  
	  }
	
}
