package com.cinch.kafka.orders.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.cinch.kafka.orders.model.CustomerName;

@Component
public class CustomerRequestConsumer {

	@Autowired
	private CustomerName customerName;

	@KafkaListener(topics = "${kafka.customer.consumer.topic-name}", containerFactory = "requestListenerContainerFactory")
	@SendTo()
	public String receive(String request) {
		customerName.setId(request);
		customerName.setFirstName("John");
		customerName.setLastName("Doe");
		return customerName.toString();
	}

}
