package com.lp.allocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.allocation.kafka.AllocationProducer;
import com.lp.order.model.Order;
import com.lp.order.model.OrderEvent;


@Service
public class AllocationResponseService {
	
	@Autowired
	AllocationProducer allocationProducer;
	
	public AllocationResponseService(AllocationProducer allocationProducer) {
		this.allocationProducer=allocationProducer;
	}

	public void produceAllocationResponse(Order order) {
		order.setAllocationId(0);
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setMessage("Allocation Sucess..!");
		orderEvent.setStatus("sucess");
		orderEvent.setOrder(order);
		allocationProducer.sendMessage(orderEvent);
	}
	
}
