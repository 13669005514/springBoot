package com.example.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * 创建消息
 * @author: fxzhang
 * @Date: 2018/12/11 20:50
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {

        this.amqpTemplate.convertAndSend("hello_mq",msg);
    }



}
