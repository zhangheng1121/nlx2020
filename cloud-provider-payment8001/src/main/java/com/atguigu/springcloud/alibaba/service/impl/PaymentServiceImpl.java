package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Project_Name: cloud2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/10/26 11:35
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }



}
