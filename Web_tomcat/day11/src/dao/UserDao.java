package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import utils.C3P0Utils;

import java.sql.SQLException;

public class UserDao {
    @Test
    public void run(){
        User user = new User();
        user.setId(8);
        user.setUsername("kk");
        user.setPassword("1243");

        save(user);
    }
    public void save(User user) {
        //获取qr对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
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
}
