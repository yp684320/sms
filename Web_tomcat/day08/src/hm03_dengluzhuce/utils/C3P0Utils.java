package hm03_dengluzhuce.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class C3P0Utils {
    // 创建连接池
    private static ComboPooledDataSource pool = new ComboPooledDataSource();

    // 提供获取连接池的方法
    public static DataSource getDataSource()  {
        return pool;
    }

    // 提供获取连接的方法
    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }


}