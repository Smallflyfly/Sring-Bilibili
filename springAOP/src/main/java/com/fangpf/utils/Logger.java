package com.fangpf.utils;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-26 10:07
 */

/**
 * @description:
 * 用于记录日志的工具，它里面提供了公共的代码
 */
public class Logger {

    /**
     * @description:
     * 用于打印日志：计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法开始记录日志了。。。");
    }
}
