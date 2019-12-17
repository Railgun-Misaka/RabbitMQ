package com.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.cp.RabbitMQConsumer;
import com.rabbitmq.cp.RabbitMQProducer;

@RestController
public class msgcontroller {
	
	@Autowired RabbitMQProducer rabbitMQProducer;
	
	@Autowired RabbitMQConsumer rabbitMQConsumer;
	
	@GetMapping("/start")
	public String sendmsg() {
		rabbitMQProducer.stringSend("asdsdad");
		return "";
	}
}
