package com.evry.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evry.DTO.Registration;


@Repository
public class RegistrationDAO {

	@Autowired
	private SessionFactory sessionfactory;
	private static Session session;
	private static Transaction tn;
	private boolean flag=true;
	
	
	//this method is used to add the user details entered as part of registration into the table "user_details_springmvc" of DB Aero.
	public boolean addUser(Registration reg)
	{
		System.out.println("Control reached DTO class");
		try {
		session=sessionfactory.openSession();
		tn=session.beginTransaction();

		
		
		
		
		session.save(reg);
		tn.commit();
		

		}
		catch(Exception e)
		{
			if(tn!=null)
			{
				tn.rollback();
			}
			flag=false;
			e.printStackTrace();
		}
		finally {
			
            session.close();
            sessionfactory.close();
		}
		
		return flag;
	}
}
