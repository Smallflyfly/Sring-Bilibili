package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-23 19:46
 */

//@Configuration
public class JdbcConfig {
    /**
     * 用于创建一个QueryRunner对象
     * */
    @Bean(name = "runner")
    @Scope(value = "prototype")  //多例
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring");
        ds.setUser("root");
        ds.setPassword("fang2831016");

        return ds;
    }
}
