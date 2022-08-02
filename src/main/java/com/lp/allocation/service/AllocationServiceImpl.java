package com.lp.allocation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.allocation.model.Allocation;
import com.lp.allocation.repository.AllocationRepository;
import com.lp.order.model.Order;

@Service
public class AllocationServiceImpl implements AllocationService {
	
	
	Allocation allocation= new Allocation();
	
	@Autowired
	AllocationRepository allocationRepository;
	
	@Override
	public void allocate(Order order) {
		
		allocation.setAllocationDate(java.time.LocalDate.now());
		allocation.setOrderId(order.getOrderId());
		allocation.setAllocationQty(order.getQuantity());
		
		
		//Save the Allocation Details in the DB 
		
		
		allocationRepository.save(allocation);
		
	}

}
