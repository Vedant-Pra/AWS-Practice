package com.ibm.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Customer")

public class Customer {
	@Id
	@Column(name="customer_id")
	private String customerId;
	@Column(name="customer_name")
	private String customerName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private Order customerOrderId;
	
	public Customer(String customerName, Order order) {
		super();
		this.customerName=customerName;
		this.customerOrderId=order;
	}
}
