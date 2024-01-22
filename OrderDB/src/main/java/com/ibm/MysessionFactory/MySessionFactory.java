package com.ibm.MysessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public class MySessionFactory {
	private static SessionFactory sessionFactory;
	static {
		try {
			sessionFactory= new Configuration().configure().addAnnotatedClass(Order.class).buildSessionFactory();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
