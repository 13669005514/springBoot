package com.example.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/13 11:38
 */
@Component
public class Provider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    //设置交换器名称
    @Value("${mq.config.exchange}")
    private String directName;

    //设置队列名称
    @Value("${mq.config.queue.info}")
    private String queueName;

    //设置路由键
    @Value("${mq.config.queue.info.routing.key}")
    private String routingKey;

    //设置路由键
    @Value("${mq.config.queue.error.routing.key}")
    private String routingKey2;

    //设置交换器名称
    @Value("${mq.config.exchange2}")
    private String directName2;

    //设置交换器名称
    @Value("${mq.config.exchange3}")
    private String directName3;


    public void send(String msg) {
        /**
         * 向消息队列发送消息
         * 1.交换器名称
         * 2.路由键名称
         * 3.消息内容
         */
        this.amqpTemplate.convertAndSend(this.directName,this.routingKey,msg);

    }

    public void send2(String msg) {
        /**
         * 向消息队列发送消息
         * 1.交换器名称
         * 2.路由键名称
         * 3.消息内容
         */
        this.amqpTemplate.convertAndSend(this.directName,this.routingKey2,msg);
    }

    public void send3(String msg) {
        /**
         * 向消息队列发送消息
         * 1.交换器名称
         * 2.路由键名称
         * 3.消息内容
         */
        this.amqpTemplate.convertAndSend(this.directName2,"user.info.key","-->>info"+msg);
        this.amqpTemplate.convertAndSend(this.directName2,"user.error.key","-->>error"+msg);
    }

    public void send4(String msg) {
        /**
         * 向消息队列发送消息
         * 1.交换器名称
         * 2.路由键名称
         * 3.消息内容
         */
        this.amqpTemplate.convertAndSend(this.directName3,"","-->>"+msg);
    }
}
