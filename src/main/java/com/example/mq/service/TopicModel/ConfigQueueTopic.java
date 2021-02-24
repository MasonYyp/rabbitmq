package com.example.mq.service.TopicModel;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigQueueTopic {

    // 管理员消息队列
    @Bean(name = "adminQue")
    public Queue createAdmin(){
        // 创建消息队列，true代表持久化
        return new Queue("adminTopic", true);
    }

    // 用户消息队列
    @Bean(name = "userQue")
    public Queue createUser(){
        return new Queue("userTopic", true);
    }


    // 创建交换机
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }


    // 绑定交换机
    @Bean
    public Binding bindingAdminExchangeMessage(@Qualifier("adminQue") Queue message, TopicExchange exchange){
        return BindingBuilder.bind(message).to(exchange).with("adminTopic");
    }

    @Bean
    public Binding bindingUserExchangeMessage(@Qualifier("userQue") Queue message, TopicExchange exchange){
        return BindingBuilder.bind(message).to(exchange).with("userTopic");
    }

}
