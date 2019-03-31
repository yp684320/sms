package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        //创建qr
        QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

        //编写sql
        String sql="select * from contact";

        //执行sql语句
        try {
            return qr.query(sql,new BeanListHandler<>(User.class));

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void del(String id) {
        //创建qr
        QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

        //编写sql
        String sql="delete from contact where id=?";

        //执行sql语句
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findByCondition(String sex, String address) {
        //创建qr
        QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

        //编写sql
        String sql="select * from contact where  1=1";
        //准备参数数组
        List<String> params=new ArrayList<>();

        if (sex!=null&&sex.trim().length()>0){
            sql+=" and  sex=?";
            params.add(sex);
        }
        if (address!=null&&address.trim().length()>0){
            sql+=" and  address=?";
            params.add(address);
        }


        //执行sql语句
        try {
            return qr.query(sql,new BeanListHandler<>(User.class),params.toArray());
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findByPage(int pageNum, int pageSize) {
        //创建qr
        QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

        //编写sql
        String sql="select * from contact limit ?,?";

        //执行sql语句
        try {
            return qr.query(sql,new BeanListHandler<>(User.class),(pageNum-1)*pageSize,pageSize);

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findTotal() {
        //创建qr
        QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

        //编写sql
        String sql="select count(*) from contact ";

        //执行sql语句
        try {
           return  ((Long)qr.query(sql,new ScalarHandler())).intValue();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
