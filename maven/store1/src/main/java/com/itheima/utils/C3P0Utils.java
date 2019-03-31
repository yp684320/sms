package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class C3P0Utils {
    // 创建连接池
    private static ComboPooledDataSource pool = new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    // 提供获取连接池的方法
    public static DataSource getDataSource()  {
        return pool;
    }
    /**
     * 从当前线程中获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        Connection conn = tl.get();
        //若是第一次获取 是null
        if(conn	== null){
            conn=pool.getConnection();

            //将这个连接和当前线程绑定
            tl.set(conn);
        }

        return conn;
    }
    /**
     *	开启事务
     * @throws SQLException
     */
    public static void beginTransaction() throws SQLException{
        //获取连接
        Connection conn = getConnection();

        //开启事务
        conn.setAutoCommit(false);
    }


    /**
     * 提交事务且释放资源
     */
    public static void commitAndClose(){
        try {
            //获取连接
            Connection conn = getConnection();

            //提交事务
            if(conn != null){
                conn.commit();
            }

            closeConn(conn);
        } catch(Exception e){

        }

    }

    /**
     * 回滚事务且释放资源
     */
    public static void rollbackAndClose(){
        try {
            //获取连接
            Connection conn = getConnection();

            //回滚事务
            if(conn != null){
                conn.rollback();
            }

            closeConn(conn);

        } catch (SQLException e) {
            //
        }
    }

    /**
     * 释放资源 且和当前线程解绑
     * @param conn
     */
    private static void  closeConn(Connection conn){
        try {
            //释放资源
            if(conn != null){
                conn.close();
            }
            //将线程和连接解绑
            tl.remove();
        } catch (Exception e) {
        }

        conn = null;
    }


}