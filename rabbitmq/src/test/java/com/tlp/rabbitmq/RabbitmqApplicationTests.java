package com.tlp.rabbitmq;

import com.tlp.rabbitmq.dao.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MessageSender messageSender;

    @Test
    public void hello() {
        //默认使用 Direct Exchange
        messageSender.send();
    }

    @Test
    public void sendUser() {
        messageSender.send();
        messageSender.sendObject();
    }

    @Test
    public void sendTopicMessage1() {
        messageSender.sendTopic1();
//        ReceiverMessages : hi, i am message 1
//        ReceiverMessage : hi, i am message 1
        //两个接收者都接收，因为 exchange 和Queue  绑定的路由键分别是 topic.message、topic.#
        //而消息发送时指定的routingkey 是 topic.message 所有两个队列都会接收

        //topic 和 direct 类似, 只是匹配上支持了"模式", 在"点分"的 routing_key 形式中, 可以使用两个通配符:
        //*表示一个词.
        //#表示零个或多个词.
    }

    @Test
    public void sendTopicMessage2() {
        messageSender.sendTopic2();
    }

    @Test
    public void sendFanoutMessage() {
        //绑定到 fanout 交换机上面的队列都收到了消息
        messageSender.sendFanout();
    }

}
