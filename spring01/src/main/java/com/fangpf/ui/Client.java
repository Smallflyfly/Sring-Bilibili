package com.fangpf.ui;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-19 14:55
 */

import com.fangpf.dao.AccountDao;
import com.fangpf.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 * */
public class Client {
        public static void main(String[] args) throws Exception {

            /**
             * 核心容器的两个接口引发的问题:
             * ApplicationContext : 单例对象适用
             *  它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，只要一读取配置文件马上就创建配置文件中的对象
             *
             *BeanFactory: 多例对象适用
             *  它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式，什么时候根据id获取对象了，什么时候才能真正的创建对象
             * */

            //获取核心容器对象
            ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            AccountService as = (AccountService) ac.getBean("accountService");
//        AccountDao adao = ac.getBean("accountDao", AccountDao.class);
        System.out.println(as);
//        System.out.println(adao);
    }
}
