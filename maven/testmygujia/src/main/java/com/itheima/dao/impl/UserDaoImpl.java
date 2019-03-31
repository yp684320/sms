package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
        /**
         * private String uid;//用户id
         private String username;
         private String password;

         private String name;
         private String email;
         private Date birthday;

         private String gender;
         private int state;//激活状态  0未激活 1已激活
         private String code;//激活码
         private String remark;//扩展字段
         */
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
        QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

        String sql="select * from user where username=? and password=?";


        try {
            return qr.query(
                    sql,new BeanHandler<>(User.class),username,password
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
