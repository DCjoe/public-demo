package com.fnl.caesar.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitDirectConfig
 * @Description 配置队列
 * @Author dengcheng
 * @Date 2018/12/4 0004 上午 10:01
 **/
@Configuration
public class RabbitDirectConfig {
    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
    @Bean
    public Queue directQueue(){
        return new Queue("direct");
    }

    /**
     * 配置默认的交换机模式，可以不需要配置以下
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    /**
     * 绑定一个key "direct"，当消息匹配到就会放到这个队列中
     * @param directQueue
     * @param directExchange
     * @return
     */
    @Bean
    public Binding bindingExchangeDirectQueue(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with("direct");
    }

}
