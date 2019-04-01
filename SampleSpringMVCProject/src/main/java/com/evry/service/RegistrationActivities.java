package com.evry.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.evry.DAO.RegistrationDAO;
import com.evry.DTO.Registration;

public class RegistrationActivities {
	
	@Autowired
	RegistrationDAO reg_dao;
	
	public void addUser(Registration reg)
	{
		
		System.out.println("control reached registration service method");
		reg_dao.addUser(reg);
	}

}
