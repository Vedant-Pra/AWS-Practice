package com.ibm.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Customers")
@Data


public class Customer {
	@Id
	@Column(name="cutomer_id")
	private String customerId;
	@Column(name="customer_name")
	private String customerName;
	@OneToMany(mappedBy = "Customers", cascade = CascadeType.ALL)
	//private Orders customerOrderId;
	private List<Orders> order;
	
	
//	public Customer(String s1,Orders order) {
//		this.customerName=s1;
//		//this.customerOrderId=order;
//	}
}
