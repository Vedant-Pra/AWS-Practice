package com.ibm.Model;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "Orders")
public class Orders {
	@Id
	@Column(name = "OrderId")
		private String orderId;
	@Column(name = "OrderType")
		private String orderType;
	@Column(name="OrderPrice")
		private double orderPrice;
	@Column(name="isConfirmed")
		private Boolean isConfirmed;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public Orders(String orderId, String orderType, double price, Boolean isConfirmed) {
		super();
		this.orderId= orderId;
		this.orderType=orderType;
		this.orderPrice=price;
		this.isConfirmed=isConfirmed;
	}
}
