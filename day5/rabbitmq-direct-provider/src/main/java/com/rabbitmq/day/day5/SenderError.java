package com.rabbitmq.day.day5;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 消息发送者
 * 泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），
 * 我们就可以使用@Component来标注这个类
 */
@Service
public class SenderError {

    // 注入Spring提供操作RabbitMq的模板类
    @Autowired
    private AmqpTemplate amqpTemplate;
    // 添加交换器的名称
    @Value("${mq.config.exchange}")
    private String exchange;
    // 添加路由键
    @Value("${mq.config.queue.error.routing.key}")
    private String routingKey;
    /**
     * 发送消息
     */
    public void sendError(String msg){
        // 向消息队列发送消息
        //参数1：交换器名称
        //参数2：路由键
        //参数3：消息
        amqpTemplate.convertAndSend(this.exchange,this.routingKey,msg);
    }
}
