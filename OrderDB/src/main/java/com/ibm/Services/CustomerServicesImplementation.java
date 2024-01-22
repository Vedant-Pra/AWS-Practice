package com.ibm.Services;
import com.ibm.Model.Customer;
import com.ibm.Repository.*;
import java.util.List;



public class CustomerServicesImplementation implements CustomerServices{

	private static CustomerRepository customerRepository;
	
	static {
		customerRepository = new CustomerRepositoryImplementation();
	}
	@Override
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.insertCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.getCustomer();
	}

	@Override
	public Customer findByCustomerId(String customerId) {
		return customerRepository.findByCustomerId(customerId);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteCustomer(customerId);
		
	}
	

}
