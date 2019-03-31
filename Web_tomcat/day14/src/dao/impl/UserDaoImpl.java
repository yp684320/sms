package dao.impl;

import dao.UserDao;
import domain.PageBean;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {
    //实现接口 重写方法快捷键是 Ctrl + i
    //创建qr对象
    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public List<User> findAll() {

        //编写sql语句
        String sql = "select * from contact";
        //执行查询
        try {
            return qr.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        //编写sql语句
        String sql = "delete from contact where id = ?";
        //执行语句
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findByCondition(String sex,String address) {
        //编写sql语句
        String sql = "select * from contact where 1=1";
        //准备参数集合
        ArrayList<String> params = new ArrayList<>();
        //判断参数是否为空
        if (sex!= null&&sex.trim().length()>0) {
            //参数存在
            sql += " and sex = ?";
            params.add(sex);
        }
        if (address!=null&&address.trim().length()>0){
            sql+=" and  address=?";
            params.add(address);
        }
        //执行语句
        try {
            return  qr.query(sql,new BeanListHandler<>(User.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findPage(int pageNum, int pageSize) {
        //编写sql语句
        String sql = "select * from contact limit ? ,?";
        //执行语句
        try {
            return  qr.query(sql,new BeanListHandler<>(User.class),(pageNum-1)*pageSize,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findTotal() {
        //编写sql语句
        String sql = "select count(*) from contact";
        //执行查询
        try {
            return ((Long)qr.query(sql, new ScalarHandler())).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


}


