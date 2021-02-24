package com.example.mq.service.DirectModel;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


/*
 * 消息消费者
 * */


@Service
public class MessageConsumerDirect {

    @RabbitListener(queues = "adminDirect")
    public void adminReceiveMsg(String msg){
        System.out.println("adminDirect 消费者收到消息 "+msg);
    }

    @RabbitListener(queues = "userDirect")
    public void userReceiveMsg(String msg){
        System.out.println("userDirect 消费者收到消息 "+msg);
    }
}
