package com.fangpf.service.impl;

import com.fangpf.dao.AccountDao;
import com.fangpf.dao.impl.AccountDaoImpl;
import com.fangpf.service.AccountService;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-19 14:45
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();
//    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    @Override
    public void saveAccount() {
        System.out.println("saveAccount方法执行了");
    }
}
