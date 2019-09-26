package com.fangpf.utils;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-26 10:07
 */

import org.aspectj.lang.ProceedingJoinPoint;

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

    /**
     * @description:
     * 环绕通知
     * Spring框架为什么提供了一个接口：ProceedingJoinPoint.该接口有一个方法proceed()，此方法就相当于明确调用切入点方法
     * 该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用
     *spring环绕通知：
     *  为我们提供的一种可以在代码中手动控制增强方法何时执行的方法
     * @return
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs(); //得到方法执行所需的参数
            System.out.println("环绕通知 aroundPrintLog  前置");
            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法)
            System.out.println("环绕通知 aroundPrintLog  后置");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知 aroundPrintLog  异常");
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕通知 aroundPrintLog  最终");
        }
        return rtValue;
    }

}
