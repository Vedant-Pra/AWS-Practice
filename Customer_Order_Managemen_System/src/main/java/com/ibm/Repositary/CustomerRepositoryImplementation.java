package com.ibm.Repositary;

import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.Models.Customer;
import com.ibm.MyFactory.MySessionFactory;

public class CustomerRepositoryImplementation implements CustomerRepository{
	private static SessionFactory sessionFactory;
	private List<Customer> customers;
	static {
		try {
			sessionFactory = MySessionFactory.getSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
	} //Static block therefore created at the start of program
	@Override
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String customerId=UUID.randomUUID().toString().split("-")[1];   // Generating random id-->Converting to string --> Splitting it in substring --> taking first part
		customer.setCustomerId(customerId);
		Session session =sessionFactory.openSession(); // Session is single thread instance of sessionFactory(multithread object that is created once per app). opensession creates a  session object to start conversation bw app and database
		session.getTransaction().begin(); // getTransation --> retrieves the current transaction associated with the session. If the session does not exist then it creates a session. .begin() will start the transaction
		session.persist(customer); // to change the Customer instance customer form traient state(not associated with any row in db) to a persistence state. In short it add customer object into the Customer table in the database as row
		session.getTransaction().commit(); //To commit the current transaction
		System.out.println("Customer added to Customer table");
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		TypedQuery<Customer> typedQuery=session.createQuery("from Customer c", Customer.class);
		customers=typedQuery.getResultList(); //Perform a sort of select all statement and return it in the form of the list
		return customers;
	}

	@Override
	public Customer findCustomerById(String customerId) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.openSession();
		Customer customer=session.find(Customer.class,customerId);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.merge(customer); // If the persistance does not exist it will create one
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public void deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		Customer customer=findCustomerById(customerId); // function defined above
		if(customer==null)
			System.out.println("Customer not found");
		else {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(customer);
			session.getTransaction().commit();
			System.out.println("Customer deleted."+customer.toString());
		}
		
	}
	
}
