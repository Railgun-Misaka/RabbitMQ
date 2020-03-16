package com.rabbitmq.cp;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "direct")
public class RabbitMQConsumer {
	
    /**
     * 消息消费
     * @throws IOException 
     * @RabbitHandler 代表此方法为接受到消息后的回调方法
     */
    @RabbitHandler
    public void recieved(String msg) throws IOException {
    	System.out.println(msg);
    }
}
