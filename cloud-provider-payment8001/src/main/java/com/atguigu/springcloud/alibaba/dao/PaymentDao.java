package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Project_Name: cloud2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/10/26 11:21
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
