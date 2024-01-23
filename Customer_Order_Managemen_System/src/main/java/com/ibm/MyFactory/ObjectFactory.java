package com.ibm.MyFactory;

import java.util.Scanner;
import java.util.UUID;

import com.ibm.Models.Customer;
import com.ibm.Models.Order;

public class ObjectFactory {
	static Scanner sc;
	static {
		sc=new Scanner(System.in);
	}
	public Customer createCustomerObject(Order order) {
		Customer customer=new Customer();
		System.out.println("Enter customer name");
		String name=sc.next();
		customer.setCustomerName(name);
		customer.setCustomerOrderId(order);
		return customer;
	}
	
	public Order createOrderObject() {
		Order order=new Order();
		order.setOrderId(UUID.randomUUID().toString().split("-")[0]);
		String ordertype;
		System.out.println("Enter order type");
		ordertype=sc.next();
		order.setOrderType(ordertype);
		System.out.println("Enter 1 to accept");
		int istrue=sc.nextInt();
		if(istrue==1)
			order.setConfirmed(true);
		else
			order.setConfirmed(false);
		
		return order;
	}
}
