package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/16 11:11
 * @Version 1.0
 */
@EnableBinding(Source.class)  // 定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****************serial: " + serial);
        return null;
    }

}
