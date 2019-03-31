package cn.itcast.aspect;

import cn.itcast.utils.JdbcUtils;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//创建切面类对象
public class MyAspecy {
    private DataSource ds;

    public void setDs(DataSource ds) {
        this.ds = ds;
    }
  private Connection connection;
    //普通增强
    public void before(){
        //获取连接
        try {
            connection = ds.getConnection();
            JdbcUtils.get().set(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //开启事务
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void afterReturning(){
        //提交事务
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void afterThrowing(){
        //回滚事务
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void after(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //使用环绕
    public void around(ProceedingJoinPoint joinPoint){
        Connection connection = null;
        try {
            //获取连接
             connection = ds.getConnection();
            JdbcUtils.get().set(connection);
            //开启事务
            connection.setAutoCommit(false);
            //执行原方法
            joinPoint.proceed();
            //提交事务
            connection.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            try {
                //回滚事务
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            //释放资源
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }






    }
}
