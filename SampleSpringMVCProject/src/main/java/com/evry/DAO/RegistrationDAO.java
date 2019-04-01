package com.evry.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.evry.DTO.Registration;


public class RegistrationDAO {

	@Autowired
	private SessionFactory sessionfactory;
	Session session;
	Transaction tn;
	
	public void addUser(Registration reg)
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
			e.printStackTrace();
		}
		finally {
			
            session.close();
            sessionfactory.close();
		}
	}
}
