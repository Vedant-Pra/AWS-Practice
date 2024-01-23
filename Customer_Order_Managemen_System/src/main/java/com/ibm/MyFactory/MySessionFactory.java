package com.ibm.MyFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.Models.Customer;
import com.ibm.Models.Order;

public class MySessionFactory {
	private static SessionFactory sessionFactory; // To create session objects which perform database operations
	static {
		try {
			sessionFactory=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Order.class).buildSessionFactory();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() throws Exception{
		return sessionFactory;
	}
}
