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
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知 Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * @description:
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知 afterReturningPrintLog...");
    }

    /**
     * @description:
     * 异常通知
     */
    public void afterThrowingPrintLong(){
        System.out.println("异常通知 afterThrowingPrintLong");
    }

    /**
     * @description:
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知 afterPrintLog");
    }

}
