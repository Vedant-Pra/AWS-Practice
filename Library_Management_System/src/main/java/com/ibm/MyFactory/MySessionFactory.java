package com.ibm.MyFactory;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ibm.Models.Book;
import com.ibm.Models.Library;

public class MySessionFactory {
	private static SessionFactory sessionfactory;
	static {
		try {
			sessionfactory=new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Library.class).buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() throws Exception{
		return sessionfactory;
	}
	
}
