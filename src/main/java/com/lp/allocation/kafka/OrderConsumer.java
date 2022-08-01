package com.lp.allocation.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.lp.order.model.Order;
import com.lp.order.model.OrderEvent;


@Service
public class OrderConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	@KafkaListener(topics="${spring.kafka.topic.name}",groupId="${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("Order event received in allocation => %s", event.toString()));
		
		// save in DB
		Order order1 = new Order();
		order1 = event.getOrder();
		System.out.println(order1.getGasStationId());
	}
}
