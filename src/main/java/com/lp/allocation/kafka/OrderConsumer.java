package com.lp.allocation.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.lp.allocation.service.AllocationCheckService;
import com.lp.order.model.OrderEvent;



@Service
public class OrderConsumer{
	
	
	@Autowired
	AllocationCheckService allocationCheckService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	@KafkaListener(topics="${spring.kafka.topic.name}",groupId="${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("Order event received in allocation => %s", event.toString()));
		
		System.out.println("order ID is "+event.getOrder().getOrderId());
		allocationCheckService.checkStock(event);
		
		
	}
	

}
