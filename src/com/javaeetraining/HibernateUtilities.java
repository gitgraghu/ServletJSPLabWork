package com.javaeetraining;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {
	private static SessionFactory sessionFactory;
	
	static
	{
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(HibernateException exception){
			System.out.println("There is an exception");
		}
		
	}
	
	public static SessionFactory getSessionFactory(){	
		return sessionFactory;
	}
}
