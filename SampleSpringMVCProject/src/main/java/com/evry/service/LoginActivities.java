package com.evry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.DAO.LoginDAO;
import com.evry.DTO.Login;

@Service
public class LoginActivities {
	
	@Autowired
     LoginDAO login_dao;
	
	
	//this method passes the login details to the method of LoginDAO class
	public boolean verifyLogin(Login logincred)
	{
		
		System.out.println("control reached registration service method");
		return login_dao.loginVerify(logincred);
	}

}
