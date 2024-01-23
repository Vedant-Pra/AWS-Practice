package com.ibm.Services;

import java.util.List;

import com.ibm.Models.Customer;
import com.ibm.Repositary.CustomerRepository;
import com.ibm.Repositary.CustomerRepositoryImplementation;

public class CustomerserviceImplementation implements CustomerService{
	private static CustomerRepository customerRepository;
	static {
		customerRepository=new CustomerRepositoryImplementation();
	}
	@Override
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.insertCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.getAllCustomer();
	}

	@Override
	public Customer findByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findCustomerById(customerId);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.updateCustomer(customer);
	}

	@Override
	public void deleteCusomer(String customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteCustomer(customerId);
		
	}
		
}
