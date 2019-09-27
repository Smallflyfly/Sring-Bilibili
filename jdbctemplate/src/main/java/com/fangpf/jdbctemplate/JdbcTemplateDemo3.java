package com.fangpf.jdbctemplate;

import com.fangpf.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-26 19:16
 * JdbcTemplate最基本用法
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {

        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作
//        jt.execute("INSERT into account(name, money) VALUES ('Lina', 3450)");
        //保存
//        jt.update("insert into account(name, money) VALUES (?, ?)","Luna",3400);
        //更新
//        jt.update("update account set name = ?, money = ? where id = ?" , "赵云", 2345,2);
        //删除
//        jt.update("delete from account where name = ?", "Han mei");
        //查询所有
//        List<Account> accounts = jt.query("select * from account where money > ?", new AccountRowMapper(), 3000);
        List<Account> accounts = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 3000);
        for(Account account:accounts){
            System.out.println(account);
        }
        //查询一个
        List<Account> accounts1 = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 5);
        System.out.println(accounts1.isEmpty()?"no found":accounts1.get(0));
        //查询返回一行一列（使用聚合函数，但不加group by子句）
        Integer count = jt.queryForObject("select count(*) from account where money > ?", Integer.class , 3000);
        System.out.println(count);
    }
}

/**
 * @description:
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{

    /**
     * @description:
     * 把结果集中的数据封装到Account中，然后由spring把每个Acccount加到集合中
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.getMoney(resultSet.getFloat("money"));
        return account;
    }
}

