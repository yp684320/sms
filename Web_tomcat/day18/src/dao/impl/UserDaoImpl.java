package dao.impl;

import dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import utils.C3P0Utils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public int count(String name) {
        //获取执行对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句
        String sql = "select count(*) from user where name = ?";
        //执行语句
        try {
            return ((Long)qr.query(sql,new ScalarHandler(),name)).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    @Test
    public void testMethod(){
        int jack = count("jack");
        System.out.println(jack);
    }
}
