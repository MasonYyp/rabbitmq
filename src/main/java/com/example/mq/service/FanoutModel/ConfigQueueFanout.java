package com.example.mq.service.FanoutModel;



import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigQueueFanout {

    // 管理员消息队列
    @Bean(name = "adminQueFanout")
    public Queue createAdmin(){
        // 创建消息队列，true代表持久化
        return new Queue("adminFanout", true);
    }

    // 用户消息队列
    @Bean(name = "userQueFanout")
    public Queue createUser(){
        return new Queue("userFanout", true);
    }


    // 创建路由器
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }


    // 绑定路由器
    @Bean
    public Binding bindingAdminFanoutExchangeMessage(@Qualifier("adminQueFanout") Queue message, FanoutExchange fanoutExchange){
        // 不绑定key
        return BindingBuilder.bind(message).to(fanoutExchange);
    }

    @Bean
    public Binding bindingUserFanoutExchangeMessage(@Qualifier("userQueFanout") Queue message, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(message).to(fanoutExchange);
    }

}
