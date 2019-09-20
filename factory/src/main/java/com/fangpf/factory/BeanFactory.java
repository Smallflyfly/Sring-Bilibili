package com.fangpf.factory;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-19 15:06
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建Bean对象的工厂
 * Bean:在计算机英语中，可重用组件的含义
 * JavaBean:用JAVA语言编写的可重用组件
 * 它就是创建文明的service和dao对象
 * 1.需要一个配置文件来配置我们的service和dao,配置的内容：唯一标识=全限定类名（key=value）
 * 2.通过读取配置文件中配置的内容，反射创建对象
 *  配置文件可以是xml也可以是properties
 * */
public class BeanFactory {
    //定义Properties对象
    private static Properties properties;

    //定义一个Map，用于存放我们要创建的对象，我们称之为容器
    private static Map<String, Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        //实例化对象
        properties = new Properties();
        //获取properties文件的流对象
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中的所有Key
            Enumeration<Object> keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean名称获取bean对象
     * */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * 根据bean名称获取bean对象
     * */
//    public static Object getBean(String beanName){
//        Object bean = null;
//        String beanPath = properties.getProperty(beanName);
//        try {
//            bean = Class.forName(beanPath).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }

}
