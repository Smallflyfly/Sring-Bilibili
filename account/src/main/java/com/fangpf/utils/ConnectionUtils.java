package com.fangpf.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-24 16:36
 *
 * 连接的工具类，它用于从数据源获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
//    private DataSource dataSource = null;￿
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @author: smallflyfly
     * @description:  获取当前线程上的连接
     * @date: 2019-09-24 19:02
     * @params:
     * @return:
     */
    public Connection getThreadConnection() throws SQLException {


        //1.先从ThreadLocal上获取
        Connection connection = tl.get();
        //2.判断当前线程上是否有连接
        if (connection == null){
            //3.从数据源中获取一个连接，并且存入ThreadLocal中
            connection = dataSource.getConnection();
            tl.set(connection);
        }
        //4.返回当前线程上的连接
        return connection;
    }

    /**
     * @description: 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
