package com.lp.allocation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.*;
import com.lp.allocation.model.Allocation;
import com.lp.allocation.repository.AllocationRepository;
import com.lp.order.model.Order;

@Service
public class AllocationServiceImpl implements AllocationService {
	
	
	
	
	Allocation allocation= new Allocation();
	
	@Autowired
	AllocationRepository allocationRepository;
	
	@Override
	public Allocation allocate(Order order) {
		
		// wait for 5 min
				
		/*
		long time = 300;
		
		TimeUnit time1 = TimeUnit.SECONDS;
		try {
			time1.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception Caught in Delay time"+ e);
		}
				
		*/		
		
		allocation.setAllocationDate(java.time.LocalDate.now());
		allocation.setOrderId(order.getOrderId());
		allocation.setAllocationQty(order.getQuantity());
		allocation.setStationId(order.getGasStationId());
		allocation.setFuelType(order.getFuelType());
		
		// wait for 5 min
		/*
		
		long time = 60;
		
		TimeUnit time1 = TimeUnit.SECONDS;
		try {
			time1.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception Caught in Delay time"+ e);
		}
		
		*/
		//Save the Allocation Details in the DB 
		
		
		return allocationRepository.save(allocation);
		
	}

}
