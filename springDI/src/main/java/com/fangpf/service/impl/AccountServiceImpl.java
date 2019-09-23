package com.fangpf.service.impl;

import com.fangpf.dao.AccountDao;
import com.fangpf.dao.impl.AccountDaoImpl;
import com.fangpf.service.AccountService;
import org.springframework.stereotype.Component;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-19 14:45
 */

/**
 * Component:
 *    作用：用于把当前类对象存入spring容器中
 *    属性：
 *         value：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写。
 * */

@Component
public class AccountServiceImpl implements AccountService {

    @Override
    public void saveAccount() {
        System.out.println("saveAccount方法执行了");
    }
}
