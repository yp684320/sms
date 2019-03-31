package anli.dao;

import anli.domain.User;
import anli.utils.C3P0Utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;


import java.sql.SQLException;

public class UserDao {
    //获取qr对象
    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
    @Test
    public void run(){
        User user = new User();
        user.setId(8);
        user.setUsername("kk");
        user.setPassword("1243");

        save(user);
    }
    public void save(User user) {

        //写sql语句
        String sql = "insert into user values(null,?,?,?,?,?,?)";
        //执行sql语句
        try {
            qr.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getGender(),user.getBirthday());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public User findUserByUsernameAndPassword(String username, String password) {
        //编写sql语句
        String sql = "select * from user where username = ? and password = ?";
        //执行查询
        try {
            return qr.query(sql,new BeanHandler<>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
