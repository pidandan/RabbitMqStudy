package com.rabbitmq.day.day3;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * 泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），
 * 我们就可以使用@Component来标注这个类
 */
@Component
public class ReceiverDay3 {
    /**
     * 接收消息的方法，采用消息队列的监听机制
     * 消息接收者如何接收RabbitMQ中的消息
     * 它使用消息队列监听器来监听消息队列，
     * 如果消息队列中有了变化那么消息监听器的事件就会产生，那么消息事件产生之后就会触发方法进行消息的接收。
     * 使用注解  @RabbitListener使得我们定义的方法成为RabbitMQ的“使者”，一旦消息队列有变化那么定义的“使者”就会有响应
     * queues参数用来声名监听那个消息队列，可以同时监测一到多个
     */
    @RabbitListener(queues = "hello-queue")
    public void process(String msg){
        System.out.print("Receiver接收到hello-queue的消息:"+msg);
    }
}
