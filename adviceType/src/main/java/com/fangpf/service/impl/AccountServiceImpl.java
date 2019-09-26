package com.fangpf.service.impl;

import com.fangpf.service.AccountService;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-26 10:04
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
//        int i = 1 / 0;
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
