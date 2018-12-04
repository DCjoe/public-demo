package com.fnl.caesar.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloReceiver
 * @Description 监听队列
 * @Author dengcheng
 * @Date 2018/12/4 0004 上午 10:06
 **/
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    @RabbitHandler
    public void process(String message){
        System.out.println("接收者 helloReceiver,"+message);
    }
}
