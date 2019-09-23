package com.fangpf.ui;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-19 14:55
 */

import com.fangpf.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 模拟一个表现层，用于调用业务层
 * */

public class Client {
        public static void main(String[] args) throws Exception {

            //获取核心容器对象
            ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            AccountService as = (AccountService) ac.getBean("accountService");
//        AccountDao adao = ac.getBean("accountDao", AccountDao.class);
        System.out.println(as);
//        System.out.println(adao);
    }
}
