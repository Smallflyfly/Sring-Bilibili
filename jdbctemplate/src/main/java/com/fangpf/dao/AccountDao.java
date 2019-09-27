package com.fangpf.dao;

import com.fangpf.domain.Account;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-27 10:29
 */
public interface AccountDao {

    Account findById(Integer id);
    Account findByName(String name);
    List<Account> findAll();
    void saveAccount(Account account);
    void deleteAccount(Integer id);
    void updateAccount(Account account);
}
