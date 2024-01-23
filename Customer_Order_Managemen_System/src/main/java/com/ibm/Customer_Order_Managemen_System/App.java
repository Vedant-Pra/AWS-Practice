package com.ibm.Customer_Order_Managemen_System;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.hibernate.internal.build.AllowSysOut;

import com.ibm.Models.Customer;
import com.ibm.Models.Order;
import com.ibm.MyFactory.ObjectFactory;
import com.ibm.Services.CustomerService;
import com.ibm.Services.CustomerserviceImplementation;

/**
 * Hello world!
 *
 */
public class App 
{
	private static CustomerService customerService;
	private static ObjectFactory objectFactory;
	static Scanner sc;
	static {
		customerService = new CustomerserviceImplementation();
		objectFactory=new ObjectFactory();
		sc=new Scanner(System.in);
	}
    public static void main( String[] args )
    {
    	int choice=0;
    	do {
    		System.out.println("0. Exit\n1. Insert Customer\n2. Get all Customer\n3. Find Customer by Id\n4. UpdateCustomer\n5. DeleteCustomer");
        	System.out.println("Enter choice");
        	choice=sc.nextInt();
        	switch(choice) {
        		case 0:
        		{
        			System.out.println("Exiting from the app");
        			break;
        		}
        		case 1:
        		{
        			Order order = objectFactory.createOrderObject();
        			Customer customer = objectFactory.createCustomerObject(order);
        			customer=customerService.insertCustomer(customer);
        			break;
        		}
        		case 2:
        		{
        			List<Customer> customerList=customerService.getAllCustomer();
        			for(Customer c:customerList)
        				System.out.println(c);
        			break;
        		}
        		case 3:
        		{
        			String customerId;
        			System.out.println("Enter Customer ID");
        			customerId=sc.next();
        			Customer customer = customerService.findByCustomerId(customerId);
        			if(customer==null)
        				System.out.println("Customer not found");
        			else
        				System.out.println("Customer: "+customer.toString());
        			break;
        		}
        		case 4:
        		{
        			String customerId;
        			System.out.println("Enter Customer Id");
        			customerId=sc.next();
        			Customer customer=customerService.findByCustomerId(customerId);
        			if(customer==null)
        				System.out.println("Customer does not exist. Create a new customer");
        			else {
        				System.out.println("Enter Name to update");
        				String name=sc.next();
        				customer.setCustomerName(name);
        				customerService.updateCustomer(customer);
        			}
        			break;	
        		}
        		case 5:
        		{
        			String customerId;
        			System.out.println("Enter Customer Id");
        			customerId=sc.next();
        			customerService.deleteCusomer(customerId);
        		}
        		break;
        		default:
        		{
        			System.out.println("Error!!! Wrong Input Choice.");
        		}
        		
        	}
    	}while(choice!=0);
    	
    }
}
