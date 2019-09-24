package com.fangpf.service.impl;

import com.fangpf.dao.AccountDao;
import com.fangpf.dao.impl.AccountDaoImpl;
import com.fangpf.domian.Account;
import com.fangpf.service.AccountService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 15:45
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;


    @Override
    public List<Account> findAllAccount() throws SQLException {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findById(Integer id) throws SQLException {
        return accountDao.findById(id);
    }

    @Override
    public void saveAccount(Account account) throws SQLException {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) throws SQLException {
        accountDao.deleteAccount(id);
    }

    public void setAccountDao(AccountDaoImpl accountDao) {
    }
}
