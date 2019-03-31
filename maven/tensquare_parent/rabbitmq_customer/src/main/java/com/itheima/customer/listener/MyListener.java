package com.itheima.customer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
//声明RabbitMQ的监听注解
@RabbitListener(queues = "itcast")
public class MyListener {

    //处理消息的方法
    //添加消息处理的注解
    @RabbitHandler()
    public void handler(String message) {
        System.out.println("消费者2收到的itcast消息是:" + message);
    }
}
