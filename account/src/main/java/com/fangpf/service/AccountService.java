package com.fangpf.service;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 15:38
 */

import com.fangpf.domian.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户业务层接口
 * */
public interface AccountService {

    List<Account> findAllAccount() throws SQLException;

    Account findById(Integer id) throws SQLException;

    void saveAccount(Account account) throws SQLException;

    void updateAccount(Account account) throws SQLException;

    void deleteAccount(Integer id) throws SQLException;

    void transfer(String sourceName, String targetName, Float money) throws Exception;

    Account findAccountByName(String name) throws SQLException, Exception;
}
