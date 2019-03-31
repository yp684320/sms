package com.itheima;

import com.itheima.Student;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    //查询所有数据的方法
    @Test
    public List<Student> query() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select *from student";
        List<Student> list = qr.query(sql, new BeanListHandler<Student>(Student.class));
     return list;

    }
    //添加数据
    public int inSert(int id,String name) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = " insert into student values(?,?)";
        int flag = qr.update(sql, id,name);
        return flag;

    }
}
