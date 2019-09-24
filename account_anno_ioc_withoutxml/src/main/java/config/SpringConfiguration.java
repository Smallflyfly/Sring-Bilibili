package config;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 19:12
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类是配置类 作用和bean.xml一样
 * spring中的新注解
 * Configureation
 *  作用：指定当前类是一个配置类
 *  细节：当配置类作为AnnotationConfigurationContext对象创建时，该注解可以不写
 *
 * ComponentScan
 *  作用:用于通过注解指定spring在创建容器时要扫描的包
 *  属性；
 *      value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。
 *              我们使用此注解就等同于在xml中配置了 <context:component-scan base-package="com.fangpf" ></context:component-scan>
 * Bean
 *  作用：用于把当前方法的返回值作为bean对象存入spring ioc容器中
 *  属性：
 *      name：用于指定bean的id.当不写时，默认值是当前方法类名
 *  细节：当我们使用注解配置方法是，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象，
 *       查找的方式和Autowired的注解是一样的
 *
 *  Import
 *      作用：用于导入其他配置类
 *      属性：
 *          value:用于指定其他配置类的字节码
 *          当我们使用Import的注解后，有Import注解的类就是父配置类，而导入的都是子配置类
 *
 * PropertySource:
 *   作用：用于指定properties文件位置
 *   属性：
 *      value:指定文件的名称和路径
 *          关键字：classpath表示类路径下
 *
 *
 * */

//@Configuration
@Import(JdbcConfig.class)
@ComponentScan(basePackages = "com.fangpf")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
