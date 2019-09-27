package com.fangpf.dao.impl;

import com.fangpf.dao.AccountDao;
import com.fangpf.domian.Account;
import com.fangpf.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 15:53
 */

/**
 * 账户持久层实现类
 * */

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;

    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public List<Account> findAllAccount() throws SQLException {
        return runner.query(connectionUtils.getThreadConnection(),"select * from account", new BeanListHandler<Account>(Account.class));
    }

    @Override
    public Account findById(Integer id) throws SQLException {
        return runner.query(connectionUtils.getThreadConnection(),"select * from account where id = ?", new BeanHandler<Account>(Account.class),id);
    }

    @Override
    public void saveAccount(Account account) throws SQLException {
        runner.update(connectionUtils.getThreadConnection(),"insert into account(name, money) values (?, ?)", account.getName(), account.getMoney());
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        runner.update(connectionUtils.getThreadConnection(),"update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void deleteAccount(Integer id) throws SQLException {
        runner.update(connectionUtils.getThreadConnection(),"delete from account where id = ?", id);
    }

    @Override
    public Account findAccountByName(String name) throws Exception {
        List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select * from account where name = ?", new BeanListHandler<Account>(Account.class), name);
        if(accounts==null || accounts.size()==0){
            System.out.println("未查找到用户"+ name +"账户信息");
            return null;
        }else if (accounts.size() > 1){
            throw new Exception("账户不唯一， 账户异常");
        }
        else{
            return accounts.get(0);
        }
    }
}
