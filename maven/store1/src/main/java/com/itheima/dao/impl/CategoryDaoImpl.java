package com.itheima.dao.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.domain.Category;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class CategoryDaoImpl implements CategoryDao {

    @Override
    public List<Category> findAll() {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select * from category";
        try {
           return qr.query(sql,new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void del(String cid) {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="delete from category where cid =?";
        try {
             qr.update(sql,cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Category category) {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="insert into category values(?,?)";
        try {
            qr.update(sql,category.getCid(),category.getCname());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category findOne(String cid) {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select * from category where cid=?";
        try {
           return qr.query(sql,new BeanHandler<>(Category.class),cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Category category) {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="update category set cname=? where cid = ?";
        try {
            qr.update(sql,category.getCname(),category.getCid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
