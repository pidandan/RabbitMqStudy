package com.rabbitmq.day.day3;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息发送者
 * 泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），
 * 我们就可以使用@Component来标注这个类
 */
@Service
public class SenderDay3 {

    // 注入Spring提供操作RabbitMq的模板类
    @Autowired
    private AmqpTemplate amqpTemplate;
    /**
     * 发送消息
     */
    public void send(String msg){
        // 向消息队列发送消息
        //参数1：标识要向那个消息队列发送消息
        //参数2：消息
        amqpTemplate.convertAndSend("hello-queue",msg);
    }
}
