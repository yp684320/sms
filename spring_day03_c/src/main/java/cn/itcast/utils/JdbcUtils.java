package cn.itcast.utils;

import java.sql.Connection;

public class JdbcUtils {
    //创建一个线程容器
    private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    public static ThreadLocal<Connection> get(){
        return tl;
    }
}
