package com.ibm.Services;

import java.util.List;

import com.ibm.Model.Customer;

public interface CustomerServices {

	Customer insertCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer findByCustomerId(String customerId);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(String customerId);
}
