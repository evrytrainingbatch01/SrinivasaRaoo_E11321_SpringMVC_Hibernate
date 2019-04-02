package com.evry.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evry.DTO.Login;
import com.evry.DTO.Registration;

@Repository
public class LoginDAO {
	
	@Autowired
	private SessionFactory sessionfactory;
	private Session session;
	private Transaction tn;
    private boolean flag=false;
	
    
    // this method is used to get the user details from DB and compare the login credentials entered to send the corresponding response accordingly
	public  boolean loginVerify(Login logincred) 
	{
		
		try {
			session=sessionfactory.openSession();
			tn=session.beginTransaction();

			
			
			
			
			Registration reg=session.get(Registration.class,logincred.getUsername());
			if(logincred.getUsername().equals(reg.getUsername()) && logincred.getPassword().equals(reg.getPassword()))
			{
				
				flag=true;
			}
			
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