package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project_Name: cloud2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/5 11:56
 * @Version 1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule nyRule(){
        return new RandomRule();    // 定义为随机
    }

}
