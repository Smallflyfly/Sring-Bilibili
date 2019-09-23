package com.fangpf.dao;

import com.fangpf.domian.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 15:48
 */
public interface AccountDao {
    List<Account> findAllAccount() throws SQLException;

    Account findById(Integer id) throws SQLException;

    void saveAccount(Account account) throws SQLException;

    void updateAccount(Account account) throws SQLException;

    void deleteAccount(Integer id) throws SQLException;
}
