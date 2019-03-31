package hm01_daima;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.C3P0Utils;

import java.sql.SQLException;

//BeanHandler：将结果集中第一条记录封装到一个指定的javaBean中

public class Demo03 {
    public static void main(String[] args) throws SQLException {
    //获取核心类对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句  并执行
        String sql = "select * from product ";
        Product product = qr.query(sql, new BeanHandler<Product>(Product.class));
        System.out.println(product);
    }
}
