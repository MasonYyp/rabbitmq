package com.example.mq.service.FanoutModel;


import com.example.mq.util.MessageProducerInter;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
* 消息生成者
* */

@Service("messageProducerFanout")
public class MessageProducerFanout implements MessageProducerInter, ConfirmCallback {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void adminSend(String msg) {
        System.out.println("adminFanout 生产者发送信息  "+msg);
        // 回调
        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.convertAndSend("adminFanout", msg);
    }

    @Override
    public void userSend(String msg) {
        System.out.println("userFanout 生产者发送信息 "+msg);
        // 回调
        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.convertAndSend("userFanout", msg);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // 确认接收成功
        if(ack){
            System.out.println("Message 接收成功！");
        }else {
            System.out.println("Message 接收失败！" + cause);
        }
    }
}
