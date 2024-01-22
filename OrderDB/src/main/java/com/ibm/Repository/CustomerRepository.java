package com.ibm.Repository;
import java.util.List;

import com.ibm.Model.Customer;
public interface CustomerRepository {
	Customer insertCustomer(Customer customer);
	List<Customer> getCustomer();
	Customer findByCustomerId(String customerId);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(String customerId);
}


