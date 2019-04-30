package com.tlp.rabbitmq.dao;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @className: MessageReceiver
 * @description: 接收者
 * @author: tianlingpeng
 * @create: 2019-04-24 11:32
 */
@Component
public class MessageReceiver {

    @RabbitListener(queues = "hello")
    public void process(String hello,Channel channel,Message message) throws IOException {
        System.out.println("Receiver : "+hello);
        //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉；否则消息服务器以为这条消息没处理掉 后续还会在发（配置文件中修改了acknowledge-mode=manual ）
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

//    @RabbitListener(queues = "hello")
//    public void processObject(User user) {
//        System.out.println("Receiver : "+user.toString());
//    }

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
