package com.fangpf;

import com.fangpf.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-26 11:06
 */
public class AOPTest {
    public static void main(String[] args) {
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //3、执行方法
        as.saveAccount();
//        as.updateAccount(10);
//        as.deleteAccount();
    }
}
