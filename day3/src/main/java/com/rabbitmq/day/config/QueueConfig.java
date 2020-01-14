package com.rabbitmq.day.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建消息队列
 * @Configuration用于定义配置类，
 *  定义的配置类可以替换xml文件，一般和@Bean注解联合使用
 * @Configuration注解主要标注在某个类上，相当于xml配置文件中的<beans>
 * @Bean注解主要标注在某个方法上，相当于xml配置文件中的<bean>
 *  SpringBoot在启动的时候会对所有类上使用@Configuration注解的进行初始化同时会对添加@Bean注解的方法进行执行
 */
@Configuration
public class QueueConfig {
    /**
     * 创建队列
     * 注意导入org.springframework.amqp.core.Queue包
     * @return
     */
    @Bean
    public Queue createQueue(){
        // 设定队列的名称
        return new Queue("hello-queue");
    }
}
