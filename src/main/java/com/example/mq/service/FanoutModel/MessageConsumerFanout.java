package com.example.mq.service.FanoutModel;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


/*
 * 消息消费者
 * */
@Service
public class MessageConsumerFanout {

    @RabbitListener(queues = "adminFanout")
    public void adminReceiveMsg(String msg){
        System.out.println("adminFanout 消费者收到消息 "+msg);
    }

    @RabbitListener(queues = "userFanout")
    public void userReceiveMsg(String msg){
        System.out.println("userFanout 消费者收到消息 "+msg);
    }
}
