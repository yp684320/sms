package cn.itcast.aspect;

import cn.itcast.utils.JdbcUtils;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyAspect {
  private DataSource ds;

    public void setDs(DataSource ds) {
        this.ds = ds;
    }
//使用环绕
    public void around(ProceedingJoinPoint joinPoint)  {
        Connection connection = null;
        try {
            //开启事务
            connection = ds.getConnection();
            connection.setAutoCommit(false);
            //将当前开启事务的connection放入线程容器中
            JdbcUtils.getTl().set(connection);
            //执行原方法
            joinPoint.proceed();
            //之后
            connection.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            try {
                //异常
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally{
            try {
                //最终
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
