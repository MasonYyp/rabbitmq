package com.example.mq.service.DirectModel;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigQueueDirect {

    // 管理员消息队列
    @Bean
    public Queue createAdmin(){
        // 创建消息队列，true代表持久化
        return new Queue("adminDirect", true);
    }

    // 用户消息队列
    @Bean
    public Queue createUser(){
        return new Queue("userDirect", true);
    }

}
