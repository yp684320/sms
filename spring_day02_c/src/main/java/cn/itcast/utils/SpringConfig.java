package cn.itcast.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

//替代配置文件
@Configuration  //代表该类是配置类  执行这个类下面的所有方法
@ComponentScan(basePackages = "cn.itcast")  //开启注解扫描
@PropertySource(value = "classpath:jdbc.properties")  //注解导入properties文件
@Import(value = JdbcConfig.class)  //集成外部的配置类
public class SpringConfig {

}
