package com.lp.allocation.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Allocation {
	@Id
	@GeneratedValue
	@Column(name="allocation_id")
	private int allocationId;
	@Column(name="order_id")
	private int orderId;
	@Column(name="allocation_date")
	private LocalDate allocationDate;
	@Column(name="allocation_qty")
	private int allocationQty;
	
}
