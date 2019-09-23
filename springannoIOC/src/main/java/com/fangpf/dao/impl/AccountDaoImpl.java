package com.fangpf.dao.impl;

import com.fangpf.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-19 14:49
 */

/**
 * 账户持久层实现类
 * */

@Repository(value = "accountDao1")
public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存了账户1111");
    }
}
