package com.fangpf;

import com.fangpf.dao.AccountDao;
import com.fangpf.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-27 11:06
 */
public class JdbcTemplateTest {

//    private AccountDao accountDao
    AccountDao accountDao = null;

    @Before
    public void init(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        accountDao = (AccountDao) ac.getBean("accountDao");
    }

    @Test
    public void findById(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        AccountDao accountDao = (AccountDao) ac.getBean("accountDao");
        Account account = accountDao.findById(8);
        System.out.println(account);
    }

    @Test
    public void findByName(){
        Account account = accountDao.findByName("小小");
        System.out.println(account);
    }

    @Test
    public void findAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void saveAccount(){
        Account account = new Account();
        account.setName("剑圣");
        account.setMoney(5678f);
        accountDao.saveAccount(account);
        findAll();
    }

    @Test
    public void updateAccount(){
        Account account = accountDao.findById(2);
        account.setMoney(4344f);
        accountDao.updateAccount(account);
        findAll();
    }

    @Test
    public void deleteAccount(){
        accountDao.deleteAccount(10);
        findAll();
    }
}
