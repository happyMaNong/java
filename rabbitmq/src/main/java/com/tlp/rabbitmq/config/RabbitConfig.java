package com.tlp.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RabbitConfig
 * @description: 队列配置类
 * @author: tianlingpeng
 * @create: 2019-04-24 11:26
 */
@Configuration
public class RabbitConfig {
    //mq的ack  主要是确认消息被消费者消费完成后通知服务器将队列里面的消息清除
    //RabbitMq 默认是no_ack=true模式，只有消息发送到消费者，就删除内存中的消息,至于异常不异常的，我不管了。通知Ack机制就是这么来的

    //Direct 类型的Exchage，根据routingkey绑定队列
    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }
    @Bean
    Binding bindingDirectMessage(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("hh");
    }



    @Bean
    public Queue queueMessage() {
        return new Queue("topic.message");
    }

    @Bean
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }

    //Topic类型的Exchage，根据通配符绑定队列
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange",true,false);
    }

    // Binding的作用就是把exchange和queue按照路由规则绑定起来
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

    //Fanout 就是我们熟悉的广播模式或者订阅模式，给 Fanout 交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
    @Bean
    public Queue queueA() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue queueB() {
        return new Queue("fanout.B");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingQueueA(Queue queueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingQueueB(Queue queueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }

}
