package com.fangpf.factory;

import com.fangpf.service.AccountService;
import com.fangpf.service.impl.AccountServiceImpl;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-20 14:54
 */
public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
