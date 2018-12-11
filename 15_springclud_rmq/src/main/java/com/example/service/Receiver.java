package com.example.service;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * 创建消息接收方
 * @author: fxzhang
 * @Date: 2018/12/11 20:54
 */
@Component
public class Receiver {


    @RabbitListener(queues = {"hello_mq"})
    public void getMsg(String msg) {
        System.out.println("成功接收信息:"+msg);
    }



}
