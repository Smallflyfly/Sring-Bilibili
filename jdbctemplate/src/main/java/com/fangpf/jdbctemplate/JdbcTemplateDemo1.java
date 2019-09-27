package com.fangpf.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-26 19:16
 * JdbcTemplate最基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源 spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring");
        ds.setUsername("root");
        ds.setPassword("fang2831016");

        //1.创建jdbcTemplate
        JdbcTemplate jt = new JdbcTemplate();
        //给jt设置数据源
        jt.setDataSource(ds);
        //2.执行操作
        jt.execute("insert into account(name, money) VALUES ('Han mei', 3000.0)");
    }
}
