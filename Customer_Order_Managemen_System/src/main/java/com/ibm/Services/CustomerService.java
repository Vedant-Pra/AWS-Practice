package com.ibm.Services;

import java.util.List;

import com.ibm.Models.Customer;

public interface CustomerService {
	Customer insertCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer findByCustomerId(String customerId);
	Customer updateCustomer(Customer customer);
	void deleteCusomer(String customerId);
}
