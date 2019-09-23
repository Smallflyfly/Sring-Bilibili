package com.fangpf.test;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 16:39
 */

import com.fangpf.domian.Account;
import com.fangpf.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用Junit单元测试
 * */
public class AccountServiceTest {

    @Test
    public void testFindAll() throws SQLException {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }

}
