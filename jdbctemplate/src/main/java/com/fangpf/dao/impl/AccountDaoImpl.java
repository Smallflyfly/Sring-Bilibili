package com.fangpf.dao.impl;

import com.fangpf.dao.AccountDao;
import com.fangpf.domain.Account;
import com.fangpf.jdbctemplate.JdbcTemplateDemo1;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-27 10:30
 */
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public List<Account> findAll() {
        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        return accounts;
    }

    public void saveAccount(Account account) {
        jdbcTemplate.update("insert into account(name, money) VALUES (?, ?)", account.getName(), account.getMoney());
    }

    public void deleteAccount(Integer id) {
        jdbcTemplate.update("delete from account where id = ?", id);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
