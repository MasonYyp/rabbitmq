package com.example.mq.service.TopicModel;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


/*
 * 消息消费者
 * */
@Service
public class MessageConsumerTopic {

    @RabbitListener(queues = "adminTopic")
    public void adminReceiveMsg(String msg){
        System.out.println("admin 消费者收到消息 topic "+msg);
    }

    @RabbitListener(queues = "userTopic")
    public void userReceiveMsg(String msg){
        System.out.println("user 消费者收到消息 topic "+msg);
    }
}
