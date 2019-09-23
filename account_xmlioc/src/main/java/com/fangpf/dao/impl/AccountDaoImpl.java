package com.fangpf.dao.impl;

import com.fangpf.dao.AccountDao;
import com.fangpf.domian.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() throws SQLException {
        return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
    }

    public Account findById(Integer id) throws SQLException {
        return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class),id);
    }

    public void saveAccount(Account account) throws SQLException {
        runner.update("insert into account(name, money) values (?, ?)", account.getName(), account.getMoney());
    }

    public void updateAccount(Account account) throws SQLException {
        runner.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

    public void deleteAccount(Integer id) throws SQLException {
        runner.update("delete from account where id = ?", id);
    }
}
