package com.rabbitmq.day.day7;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * 使用交换器方式进行消息接收，那么我们需要知道接收的是那个交换器的消息以及是那个Queue中的消息因此我们将进行相关的配置
 * @RabbitListener  bindings: 绑定队列，也就是说这个消费者从那个队列中获取消息
 * @QueueBinding 绑定队列的详细配置
 *          value绑定队列的名称
 *          exchange配置交换器
 *          key路由键
 * @Queue指配置具体的队列，
 *          value属性为队列的名称
 *          autoDelete是否是一个可删除的临时队列
 *@Exchange指配置交换器
 *          value属性为交换器起个名称
 *          type属性为指定具体的交换器类型
 */
@Component
@RabbitListener(
        bindings =@QueueBinding(
            value = @Queue(value="${mq.config.queue.push}",autoDelete = "true"),
            exchange =@Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.FANOUT)
        )
)
public class PushReceiver {
    // 经过RabbitListener配置信息可以知道，当前消息队列接收的是那个交换器以那种订阅模式接收那个消息队列中那个路由键的信息
    @RabbitHandler
    public void process(String msg){
        System.out.print("Push Receiver接收到的消息:"+msg);
    }
}
