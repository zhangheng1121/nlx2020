package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/27 14:40
 * @Version 1.0
 */
@RestController
public class OrderController {

    @Resource
    public OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

    @GetMapping("/order/getIDBySnowFlake")
    public String getIDBySnowFlake(){
        return orderService.getIDBySnowFlake();
    }

}
