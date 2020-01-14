package com.rabbitmq.day.day6;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 消息发送者 用户服务
 */
@Service
public class UserSenderInfo {

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
        // 参数1：交换器名称
        // 参数2：路由键
        // 参数3：消息
        // 会进入到全日志消息队列
        amqpTemplate.convertAndSend(this.exchange,"user.log.debug","user.log.debug"+ msg);
        // 会进入到info日志消息队列和全日志消息队列
        amqpTemplate.convertAndSend(this.exchange,"user.log.info","user.log.info"+ msg);
        // 会进入到全日志消息队列
        amqpTemplate.convertAndSend(this.exchange,"user.log.warn","user.log.warn"+ msg);
        // 会进入到error日志消息队列和全日志消息队列
        amqpTemplate.convertAndSend(this.exchange,"user.log.error","user.log.error"+ msg);
    }
}
