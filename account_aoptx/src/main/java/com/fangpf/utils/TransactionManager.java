package com.fangpf.utils;

import java.sql.SQLException;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-24 19:18
 *
 * 和事务管理相关的接口，它包含开启事务、提交事务、回滚事务和释放连接
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * @description: 开启事务
     */
    public void beginTransaction() throws SQLException {
        connectionUtils.getThreadConnection().setAutoCommit(false);
    }

    /**
     * @description: 提交事务
     */
    public void commit() throws SQLException {
        connectionUtils.getThreadConnection().commit();
    }

    /**
     * @description: 回滚事务
     */
    public void rollback() throws SQLException {
        connectionUtils.getThreadConnection().rollback();
    }

    /**
     * @description: 释放连接
     */
    public void release() throws SQLException {
        connectionUtils.getThreadConnection().close();
        connectionUtils.removeConnection();
    }
}
