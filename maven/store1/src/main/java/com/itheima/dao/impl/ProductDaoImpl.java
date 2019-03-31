package com.itheima.dao.impl;

import com.itheima.constants.Global;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> findHots() {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select * from product where is_hot=? and pflag=? limit 0,9";
        try {
            return qr.query(sql,new BeanListHandler<>(Product.class), Global.PRODUCT_IS_HOT,Global.PRODUCT_FLAG_ON);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findNews() {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select * from product where pflag=? order by pdate desc limit 0,9";
        try {
            return qr.query(sql,new BeanListHandler<>(Product.class),Global.PRODUCT_FLAG_ON);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findOne(String pid) {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select * from product where pflag =? and pid=?";
        try {
            return qr.query(sql,new BeanHandler<>(Product.class),Global.PRODUCT_FLAG_ON,pid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findByPageWithCid(String cid, int pageNumber, int pageSize) {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select * from product where pflag =? and cid = ? limit ? ,?";
        try {
            return qr.query(sql,new BeanListHandler<>(Product.class),Global.PRODUCT_FLAG_ON,cid,(pageNumber-1)*pageSize,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findTotalByCid(String cid) {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select count(*) from product where pflag =? and cid = ? ";
        try {
            return ((Long) qr.query(sql,new ScalarHandler(),Global.PRODUCT_FLAG_ON,cid)).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
