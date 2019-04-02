package com.evry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.DAO.RegistrationDAO;
import com.evry.DTO.Registration;


@Service
public class RegistrationActivities {
	
	@Autowired
	RegistrationDAO reg_dao;
	
	
	//this method passes the registratoin details to the method of RegistrationDAO class
	public boolean addUser(Registration reg)
	{
		
		System.out.println("control reached registration service method");
		return reg_dao.addUser(reg);
	}

}
