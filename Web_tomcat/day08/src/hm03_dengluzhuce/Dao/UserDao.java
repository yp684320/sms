package hm03_dengluzhuce.Dao;

import hm03_dengluzhuce.Domain.User;
import hm_02dengluanli.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //判断是否成功连接数据库
//    @Test
//    public void run() throws SQLException {
//        User user = new User();
//        queryUser(user);
//    }
    //通过用户查询数据
    public boolean queryUser(User user) throws SQLException {

        //获取执行对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句
        String sql = "select * from user where username = ? and password = ?";
        //执行语句
        User user1 = qr.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
        if (user1 != null) {
            return true;
        }
        return false;

    }

}


