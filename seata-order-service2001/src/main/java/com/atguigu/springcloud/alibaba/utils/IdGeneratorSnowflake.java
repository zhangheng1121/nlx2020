package com.atguigu.springcloud.alibaba.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/30 15:45
 * @Version 1.0
 */
@Component
@Slf4j
public class IdGeneratorSnowflake {

    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct
    public void init(){
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId: {}", workerId);
        }catch (Exception e){
            e.printStackTrace();
            log.warn("当前机器的workerId获取失败", e);
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

}
