package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.alibaba.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/16 11:20
 * @Version 1.0
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }


}
