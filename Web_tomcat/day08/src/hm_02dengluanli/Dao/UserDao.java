package hm_02dengluanli.Dao;

import hm_02dengluanli.Domain.User;
import hm_02dengluanli.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;

public class UserDao {
    @Test//判断是否成功连接数据库
    public void run() throws SQLException {
        boolean tom = queryUserByUsernameAndPassword("Tom", "123");
        System.out.println(tom );
    }
    //通过用户名和密码进行查找
    public boolean queryUserByUsernameAndPassword(String username ,String password) throws SQLException {
        //创建queryrunner对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句
        String sql = "select * from user where username = ? and password = ?";
        //执行sql语句
        User user = qr.query(sql, new BeanHandler<>(User.class), username , password);
        //查到用户返回 true 否则 返回 false
        return user != null;

    }
    public boolean updateUser(String username,String password) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into user values(null,?,?)";
        int update = qr.update(sql,username,password);
        if (update > 0) {
            return true;
        }
        return false;

    }
}
