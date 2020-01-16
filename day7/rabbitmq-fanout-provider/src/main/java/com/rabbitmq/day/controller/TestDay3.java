package com.rabbitmq.day.controller;

import com.rabbitmq.day.day7.SenderInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "消息队列测试day3")
@RestController
@RequestMapping("/day3")
public class TestDay3 {

    @Autowired
    private SenderInfo senderInfo;

    @ApiOperation(value = "向消息队列发送消息")
    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    public void sedMessage(){
        senderInfo.sendInfo("day3测试数据");
    };


}
