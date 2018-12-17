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
                        value = @Queue(value = "${mq.config.queue.sso}",autoDelete = "true"),
                        exchange =@Exchange(value = "${mq.config.exchange3}",type = ExchangeTypes.FANOUT)
                )
        }
)
public class SsoConsumer {


    @RabbitHandler
    public void pross(String msg) {

        System.out.println("sso接收到的信息:"+msg);
    }



}
