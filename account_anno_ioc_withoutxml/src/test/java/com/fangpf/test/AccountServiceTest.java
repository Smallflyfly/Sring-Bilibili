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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用Junit单元测试
 * */
public class AccountServiceTest {

    //1.获取容器
   private ApplicationContext ac = null;
   private AccountService as = null;


    @Before
    public void init(){
        //1.获取容器
//        ac = new ClassPathXmlApplicationContext("bean.xml");
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象

        as = ac.getBean("accountService", AccountService.class);
    }

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
