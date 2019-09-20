package com.fangpf.ui;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-19 14:55
 */

import com.fangpf.factory.BeanFactory;
import com.fangpf.service.AccountService;
import com.fangpf.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 * */
public class Client {
    public static void main(String[] args) throws Exception {
//        AccountService accountService = new AccountServiceImpl();
        AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
        accountService.saveAccount();
    }
}
