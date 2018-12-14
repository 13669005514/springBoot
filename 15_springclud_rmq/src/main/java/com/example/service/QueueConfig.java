package com.example.service;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * 创建消息队列
 * @author: fxzhang
 * @Date: 2018/12/11 20:49
 */
@Configuration
public class QueueConfig {

    @Bean
    public Queue queue() {

        return  new Queue("hello_mq");
    }
}
