package com.example.mq;

import com.example.mq.util.MessageProducerInter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MessageQueFanoutTest {

    @Autowired
    @Qualifier("messageProducerFanout")
    private MessageProducerInter messageProducer;

    @Test
    public void test() throws InterruptedException {
        for (int i=0; i<10; i++){

            this.messageProducer.adminSend(" "+i);
            this.messageProducer.userSend(" "+i);

            Thread.sleep(1000);
        }
    }
}
