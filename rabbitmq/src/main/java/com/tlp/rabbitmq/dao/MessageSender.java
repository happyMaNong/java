package com.tlp.rabbitmq.dao;

import com.tlp.rabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

/**
 * @className: MessageSender
 * @description:
 * @author: tianlingpeng
 * @create: 2019-04-24 11:27
 */
@Component
public class MessageSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String message = "hello mq! " + LocalDate.now();
        System.out.println("send: " + message);
        //routingKey 路由键 ,direct模式默认为它的队列名
        rabbitTemplate.convertAndSend("directExchange","hh", message);
    }

    public void sendObject() {
        User user = new User();
        user.setId(1);
        user.setName("杜小帅");
        user.setAddress("美国金州");
        user.setAge(30);
        user.setScore(99.99);
        user.setBirthday(new Date());
        System.out.println("send: " + user.toString());
        rabbitTemplate.convertAndSend("directExchange","hh", user);
    }

    public void sendTopic1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("exchange","topic.message",context);
    }

    public void sendTopic2() {
        String context = "hi, i am message 2";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("exchange","topic.messages",context);
    }

    public void sendFanout() {
        String context = "hi, everybody";
        System.out.println("FanoutSender : " + context);
        rabbitTemplate.convertAndSend("fanoutExchange", "", context);
    }
}
