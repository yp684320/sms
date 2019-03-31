package com.itheima.dao;

import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;


import java.sql.SQLException;

public class ProductDao {
    //添加数据
    public int insert( int id, String pname, int price) throws SQLException {
        //获取核心类对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //写sql语句
        String sql = "insert into product values(?,?,?)";
        //执行语句
        int flag = qr.update( sql, id, pname, price);
        return flag;

    }

}
