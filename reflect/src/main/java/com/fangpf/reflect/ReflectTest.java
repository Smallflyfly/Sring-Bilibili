package com.fangpf.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-19 10:39
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("config.properties");
        properties.load(in);

        //获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //加载该类进内存
        Class cls = Class.forName(className);
        //创建对象
        Object obj = cls.newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        //执行方法
        method.invoke(obj);
    }
}
