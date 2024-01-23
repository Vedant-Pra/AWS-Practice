package com.ibm.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Orders")
public class Order {
	@Id
	@Column(name="order_id")
	private String orderId;
	
	@Column(name="order_type")
	private String orderType;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
}
