package com.tlp.rabbitmq.dao;

import com.tlp.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: MessageReceiver
 * @description: 接收者
 * @author: tianlingpeng
 * @create: 2019-04-24 11:32
 */
@Component
public class MessageReceiver {

    @RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiver : "+hello);
    }

    @RabbitListener(queues = "hello")
    public void processObject(User user) {
        System.out.println("Receiver : "+user.toString());
    }

    @RabbitListener(queues = "topic.message")
    public void processMessage(String hello) {
        System.out.println("ReceiverMessage : "+hello);
    }

    @RabbitListener(queues = "topic.messages")
    public void processMessages(String hello) {
        System.out.println("ReceiverMessages : "+hello);
    }

    @RabbitListener(queues = "fanout.A")
    public void processFanoutA(String hello) {
        System.out.println("fanout.A  receiver: "+hello);
    }

    @RabbitListener(queues = "fanout.B")
    public void processFanoutB(String hello) {
        System.out.println("fanout.B  receiver : "+hello);
    }
}
