package cn.itcast.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//第三方资源
public class JdbcConfig {
//设置第三方的资源都的有返回值
    @Value(value = "${jdbc.driver}")
    private String driver;
    @Value(value = "${jdbc.url}")
    private String url;
    @Value(value = "${jdbc.username}")
    private String username;
    @Value(value = "${jdbc.password}")
    private String password;

    //c3p0
    @Bean(value = "c3p0")
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();//ioc
        dataSource.setDriverClass(driver);//di
        dataSource.setJdbcUrl(url);//di
        dataSource.setUser(username);//di
        dataSource.setPassword(password);//di
        return dataSource;

    }

    //QueryRunner
    @Bean(value = "queryRunner")
    public QueryRunner getQueryRunner(@Qualifier(value = "c3p0") DataSource dataSource){
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }
}
