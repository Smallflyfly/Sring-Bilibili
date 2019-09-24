package com.fangpf.utils;

import java.sql.Connection;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-24 16:36
 *
 * 连接的工具类，它用于从数据源获取一个连接，并且实现和线程的绑定
 */
public class ConnectUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
}
