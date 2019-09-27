package com.fangpf.test;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 16:39
 */

import com.fangpf.domian.Account;
import com.fangpf.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用Junit单元测试
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService as = null;


    @Test
    public void testFindAll() throws Exception {
        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindByName() throws Exception {
        Account account =  as.findAccountByName("Lily");
        System.out.println(account);
    }

    @Test
    public void testTransfer() throws Exception {
        as.transfer("小小", "Jack", 1000f);
        testFindAll();
    }
}
