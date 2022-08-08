package com.lp.allocation.kafka;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.lp.allocation.service.DispatchUpdatesService;
import com.lp.order.model.OrderEvent;





@Service
public class DispatchConsumer{
	
	
	@Autowired
	DispatchUpdatesService dispatchUpdatesService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DispatchConsumer.class);
	
	@KafkaListener(topics="${spring.kafka.topic.name-dispatch}",groupId="${spring.kafka.consumer.group-dispatch-id}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("Dispatch event received in Allocation service => %s", event.toString()));
		
		//System.out.println("order ID iss "+event.getOrder().getOrderId());
		dispatchUpdatesService.updateDispatchStatus(event);
		
		
	}
	
	

}
