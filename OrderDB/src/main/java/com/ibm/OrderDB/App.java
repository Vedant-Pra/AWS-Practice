package com.ibm.OrderDB;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.Model.*;

import com.ibm.Services.CustomerServices;
import com.ibm.Services.CustomerServicesImplementation;


public class App {
	public  CustomerServices customerService;
	{
		customerService=new CustomerServicesImplementation();
	}
	
	public static void main(String args[]) {
		
		 Orders order = new Orders(); 
		 String orderId = UUID.randomUUID().toString();
		 String [] str = orderId.split("-"); orderId = str[0];
		 order.setOrderId(orderId); order.setOrderType("Garments");
		 order.setOrderPrice(10087.25); 
		 order.setIsConfirmed(true);
		 
		 Customer customer = new Customer();
		  
		 customer =new App(). customerService.insertCustomer(customer);
		 System.out.println("Customer inserted: " + customer);
		  
//			
//		 List<Customer> customers = customerService.getAllCustomer(); 
//		 for ( Customer c: customers) 
//			 System.out.println(c);
//		 Customer c = null; 
//		 c = customerService.findByCustomerId("f38d43f5-3"); 
//		 if(c == null) System.out.println("Customer not found"); 
//		 else
//			 System.out.println("Customer found: " + c);
//		 Customer c1 = customerService.findByCustomerId("3eb2d34d");
//		 c1.setCustomerName("Mary Lawrence");
//		 c1.getCustomerOrderId().setOrderType("Groceries"); c1 =
//		 customerService.updateCustomer(c1); System.out.println("Customer updated: " +c1);
//		customerService.deleteCustomer("3dc7e683-d3a1-48df-baec-bbd7ff6f63ca");
	}
}

