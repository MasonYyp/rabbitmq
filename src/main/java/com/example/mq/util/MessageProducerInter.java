package com.example.mq.util;

public interface MessageProducerInter {

    // 管理发送数据
    public void adminSend(String msg);

    // 用户发送数据
    public void userSend(String msg);

}
