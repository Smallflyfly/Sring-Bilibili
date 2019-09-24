package com.fangpf.test;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 16:39
 */

import com.fangpf.domian.Account;
import com.fangpf.service.AccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用Junit单元测试
 * junit集成了一个main,该方法就会判断当前测试类中哪些方法有@Test注解，junit就让有Test注解的方法执行
 *
 *当测试方法执行时，没有IOC容器
 *
 * spring整合junit的配置
 *  1.导入spring整合junit的jar
 *  2.使用junit提供一个注解把原有的main方法替换了，替换成spring提供的
 *     @Runwith
 *  3.告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *     @ContextConfiguration
 *          location:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *          classes：指定注解类所在位置
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    //1.获取容器
    @Autowired
    private AccountService as = null;


//    @Before
//    public void init(){
//        //1.获取容器
////        ac = new ClassPathXmlApplicationContext("bean.xml");
////        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
////        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//
//        //2.得到业务层对象
//
////        as = ac.getBean("accountService", AccountService.class);
//    }

    @Test
    public void testFindAll() throws SQLException {
//        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        //2.得到业务层对象
//        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() throws SQLException {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        AccountService as = ac.getBean("accountService", AccountService.class);
        Account account = as.findById(2);
        System.out.println(account);
    }

    @Test
    public void testInsert() throws SQLException {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        AccountService as = ac.getBean("accountService", AccountService.class);
        Account account = new Account();
        account.setName("Jack");
        account.setMoney(5000.0f);
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() throws SQLException {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        AccountService as = ac.getBean("accountService", AccountService.class);
        Account account = new Account();
        account.setName("Han mei");
        account.setId(4);
        account.setMoney(3000.0f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() throws SQLException {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        AccountService as = ac.getBean("accountService", AccountService.class);
        as.deleteAccount(4);
    }

}
