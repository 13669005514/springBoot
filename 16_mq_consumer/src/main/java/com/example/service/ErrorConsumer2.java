package com.example.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * 消息接收者(消费者)
 * @author: fxzhang
 * @Date: 2018/12/13 11:45
 */
@Component
@RabbitListener(
        bindings = {
                @QueueBinding(
                        value = @Queue(value = "${mq.config.queue.error2}",autoDelete = "true"),
                        exchange =@Exchange(value = "${mq.config.exchange2}",type = ExchangeTypes.TOPIC),
                        key = "${mq.config.queue.error.routing.key2}"
                )
        }
)
public class ErrorConsumer2 {


    @RabbitHandler
    public void pross(String msg) {

        System.out.println("error2:"+msg);
    }



}
