package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Project_Name: cloud2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/9 15:01
 * @Version 1.0
 */
@Service
public class PaymentService {

    // ---------------- 服务降级 -------------------------
    /**
     * 正常访问肯定OK的方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_OK, id:  " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            // 自己设置峰值上线 5秒（5秒以内走正常方法，5秒以上走 paymentInfo_TimeOutHandler 方法）
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        //int age = 10/0;
        try {
            // 暂停毫秒
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " -- id:  " + id + "\t" + "O(∩_∩)O哈哈~";
    }
    public String paymentInfoTimeOutHandler(Integer id){
        return "线程池： " + Thread.currentThread().getName() + " -- 8001系统繁忙，请稍后再试, id:  " + id + "\t" + "o(╥﹏╥)o";
    }


    // -------------- 服务熔断 -------------------
    // 10秒钟的时间内，如果请求10次，失败率超过60%，进行熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号： " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，/o(╥﹏╥)o/~~  id: " + id;
    }


}
