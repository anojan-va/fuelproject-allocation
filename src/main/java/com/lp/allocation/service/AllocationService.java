package com.lp.allocation.service;


import com.lp.allocation.model.Allocation;
import com.lp.order.model.Order;

public interface AllocationService{
	
	public Allocation allocate(Order order);

}
