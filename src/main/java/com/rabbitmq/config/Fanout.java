package com.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 广播方式
 * @author Fly
 *
 */
@Configuration
public class Fanout {

        @Bean(name="Amessage")
        public Queue AMessage() {
            return new Queue("fanout.A");
        }

        @Bean(name="Bmessage")
        public Queue BMessage() {
            return new Queue("fanout.B");
        }

        @Bean(name="Cmessage")
        public Queue CMessage() {
            return new Queue("fanout.C");
        }

        @Bean
        FanoutExchange fanoutExchange() {
            return new FanoutExchange("fanoutExchange");//配置广播路由器
        }
        
        /**
         * a绑定交换机
         * @param AMessage  绑定对象
         * @param fanoutExchange  交换机
         * @return
         */
        @Bean
        Binding bindingExchangeA(@Qualifier("Amessage") Queue AMessage,FanoutExchange fanoutExchange) {
            return BindingBuilder.bind(AMessage).to(fanoutExchange);
        }

        @Bean
        Binding bindingExchangeB(@Qualifier("Bmessage") Queue BMessage, FanoutExchange fanoutExchange) {
            return BindingBuilder.bind(BMessage).to(fanoutExchange);
        }

        @Bean
        Binding bindingExchangeC(@Qualifier("Cmessage") Queue CMessage, FanoutExchange fanoutExchange) {
            return BindingBuilder.bind(CMessage).to(fanoutExchange);
        }

}
