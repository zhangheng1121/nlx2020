package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Project_Name: cloud2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/10/26 14:47
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced   // 负载均衡配置
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
