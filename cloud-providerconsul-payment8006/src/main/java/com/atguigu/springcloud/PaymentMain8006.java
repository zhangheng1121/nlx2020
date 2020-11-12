package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Project_Name: cloud2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/3 15:00
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient  // 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
    }
}
