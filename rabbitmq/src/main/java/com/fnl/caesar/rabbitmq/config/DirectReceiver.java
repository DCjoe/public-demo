package com.fnl.caesar.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName DirectReceiver
 * @Description 监听队列
 * @Author dengcheng
 * @Date 2018/12/4 0004 上午 10:10
 **/
@Component
@RabbitListener(queues = "direct")
public class DirectReceiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("接收者 DirectReceiver," + message);
    }
}
