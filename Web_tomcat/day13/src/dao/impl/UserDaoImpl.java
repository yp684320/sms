package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //创建执行对象
    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public List<User> findAll() {


        String sql = "select * from contact";
        //ִ执行sql语句
        try {
            return qr.query(sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        //ִ编写sql语句
        String sql = "delete from contact where id = ?";
        //ִ执行sql语句
        try {
            qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
