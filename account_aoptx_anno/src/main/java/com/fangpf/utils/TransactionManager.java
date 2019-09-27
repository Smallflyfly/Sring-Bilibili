package com.fangpf.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-24 19:18
 *
 * 和事务管理相关的接口，它包含开启事务、提交事务、回滚事务和释放连接
 */

@Component("transactionManger")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.fangpf.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * @description: 开启事务
     */
    public void beginTransaction() throws SQLException {
        System.out.println("begin......");
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

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        Object rtValue = null;
        try {
            //1.获取参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3、执行方法
            rtValue = pjp.proceed(args);
            //4.提交事务
            this.commit();

            //返回结果
            return rtValue;
         } catch (Throwable e){
            throw  new RuntimeException(e);
        } finally {
            //释放资源
            this.release();
        }

    }
}
