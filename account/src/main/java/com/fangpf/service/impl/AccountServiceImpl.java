package com.fangpf.service.impl;

import com.fangpf.dao.AccountDao;
import com.fangpf.domian.Account;
import com.fangpf.service.AccountService;
import com.fangpf.utils.TransactionManager;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 15:45
 *
 * 账户业务类实现层
 *
 * 事务控制应该都在业务层
 *
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() throws Exception {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findById(Integer id) throws Exception {
        return accountDao.findById(id);
    }

    @Override
    public void saveAccount(Account account) throws Exception {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) throws Exception {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) throws Exception {
        accountDao.deleteAccount(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) throws Exception {
        //1.根据名称查询转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //2.根据名称查询转入账户
        Account targetAccount = accountDao.findAccountByName(targetName);
        //3.转出账户减钱
        sourceAccount.setMoney(sourceAccount.getMoney() - money);

//            double err = 1/0;

        //4.转入账户加钱
        targetAccount.setMoney(targetAccount.getMoney() + money);
        //5.更新转出账户
        accountDao.updateAccount(sourceAccount);
        //6.更新转入账户
        accountDao.updateAccount(targetAccount);
    }

    @Override
    public Account findAccountByName(String name) throws Exception {
        return accountDao.findAccountByName(name);
    }
}
