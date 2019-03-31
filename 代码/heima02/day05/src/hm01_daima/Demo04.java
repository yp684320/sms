package hm01_daima;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

//BeanListHandler：将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中
public class Demo04 {
    public static void main(String[] args) throws SQLException {
        //获取核心类对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句  并执行
        String sql = "select * from product";
        List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
        //遍历集合
        for (Product product : list) {
            System.out.println(product);
        }

    }
}
