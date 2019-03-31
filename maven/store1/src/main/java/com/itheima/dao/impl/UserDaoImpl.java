package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.C3P0Utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;


import java.sql.SQLException;


public class UserDaoImpl implements UserDao {

    @Override
    public void save(User user) {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";


        try {
            qr.update(
                    sql,
                    user.getUid(),user.getUsername(),user.getPassword(),
                    user.getName(),user.getEmail(),user.getBirthday(),
                    user.getGender(),user.getState(),user.getCode(),user.getRemark()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUser(String username, String password) {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
         //编写sql语句
        String sql="select * from user where username = ? and password = ?";
         //查询语句

        try {
           return qr.query(sql,new BeanHandler<>(User.class),username,password)
            ;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
