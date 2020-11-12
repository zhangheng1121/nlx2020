package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/11 15:10
 * @Version 1.0
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // https://news.baidu.com/guonei
        routes.route("path route atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        // routes.route("path route atguigu", r -> r.path("/**").uri("http://news.baidu.com/**")).build();
        return routes.build();
    }

}
