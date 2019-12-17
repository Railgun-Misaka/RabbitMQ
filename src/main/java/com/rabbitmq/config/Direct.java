package com.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Direct {
	
	@Bean
    public Queue time() {
        return new Queue("direct");
    }
}
