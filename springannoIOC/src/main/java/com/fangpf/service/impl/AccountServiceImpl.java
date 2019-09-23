package com.fangpf.service.impl;

import com.fangpf.dao.AccountDao;
import com.fangpf.service.AccountService;
import com.sun.scenario.effect.impl.prism.PrImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-19 14:45
 */

/**
 * Component:
 *    作用：用于把当前类对象存入spring容器中
 *    属性：
 *         value：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写。
 *
 * Controller: 一般用于表现层
 * Service: 一般用于业务层
 * Repository: 一般用于持久层
 * 以上三个注解他们的作用和属性与Component是一模一样的
 * 他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *
 *  Autowired：
 *    作用：自动按照类型注入。只要容器有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *         如果ioc容器中没有任何bean的类型和要注入的变量类型匹配
 *         如果ioc容器中有多个类型匹配时
 *    出现位置：
 *       可以是变量上，也可以是方法上
 *    细节：
 *        在使用注解注入时，set方法就不是必须的了
 *  Qualifier:
 *    作用:在按照类中注入的基础上再按照名称注入。它在给类成员注入时不能单独使用，但是在给方法参数注入时可以
 *    属性:用于指定注入bean的id
 *    与Autowired一起使用
 *  Resource:
 *    作用：直接按照bean的id注入。它可以单独使用
 *    属性：
 *      name：用于指定bean的id
 *  以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 *  另外集合类型的注入只能通过xml实现
 *
 *  Value：
 *      用于注入基本类型和String类型的数据
 *      属性：
 *          value：用于指定数据的值。它可以使用String中SpEL(也就是spring的el表达式)
 *                 SpEL的写法：${表达式}
 *
 * 用于改变作用范围的
 *      他们的作用和bean标签中使用scope属性实现的功能是一样的
 *      Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。常用取值：singleton prototype
 *
 *  和生命周期相关
 *      他们的作用就和bean标签中使用init-method和destroy-method的作用是一样的
 *      PreDestroy
 *          作用：用于指定销毁方法
 *      PostConstruct
 *          作用：用于指定初始化方法
 *
 * */

@Service(value = "accountService")
@Scope(value = "singleton")
public class AccountServiceImpl implements AccountService {

//    @Autowired
//    @Qualifier(value = "accountDao2")
    @Resource(name = "accountDao1")
    private AccountDao accountDao = null;

    @PostConstruct
    public void init(){
        System.out.println("init....");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
