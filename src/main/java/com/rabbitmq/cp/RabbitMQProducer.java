package com.rabbitmq.cp;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {
	
	@Autowired private AmqpTemplate rabbitTemplate;

    public void stringSend(String msg) {
    	
    	if(msg == null)
    		return ;
    	
        /**
         * fanout.time  队列名称
         * massage
         */
        this.rabbitTemplate.convertAndSend("direct", msg);
    }
    //autowired注入之后调用
    @PostConstruct
    public void a() {
    }
}
