package com.ibm.Repositary;

import java.util.List;

import com.ibm.Models.Customer;

public interface CustomerRepository {
	Customer insertCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer findCustomerById(String customerId);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(String customerId);
}
