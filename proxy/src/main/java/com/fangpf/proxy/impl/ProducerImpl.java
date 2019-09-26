package com.fangpf.proxy.impl;

import com.fangpf.proxy.Producer;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-25 11:10
 */
public class ProducerImpl implements Producer {
    @Override
    public void saleProducer(float money) {
        System.out.println("销售产品，并拿到钱:" + money);
    }

    @Override
    public void afterService(float money) {
        System.out.println("提供售后服务，并拿到钱:" + money);
    }

//    @Override
//    public void saleProducer(float money) {
//        System.out.println("销售产品，并拿到钱:" + money);
//    }
//
//    @Override
//    public void afterService(float money) {
//        System.out.println("提供售后服务，并拿到钱:" + money);
//    }
}
