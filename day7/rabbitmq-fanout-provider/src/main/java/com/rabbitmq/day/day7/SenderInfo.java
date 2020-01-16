package com.rabbitmq.day.day7;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 消息发送者
 */
@Service
public class SenderInfo {

    // 注入Spring提供操作RabbitMq的模板类
    @Autowired
    private AmqpTemplate amqpTemplate;
    // 添加交换器的名称
    @Value("${mq.config.exchange}")
    private String exchange;

    /**
     * 发送消息
     */
    public void sendInfo(String msg){
        // 向消息队列发送消息
        //参数1：交换器名称
        //参数2：路由键 因为交换器使用的fanout类型 那么不存在路由键的概念，因此此处第二个参数使用空字符串
        //参数3：消息
        amqpTemplate.convertAndSend(this.exchange,"",msg);
    }
}
