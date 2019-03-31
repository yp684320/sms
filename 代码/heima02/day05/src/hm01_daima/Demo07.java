package hm01_daima;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.C3P0Utils;

import java.sql.SQLException;

public class Demo07 {
    public static void main(String[] args) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into user values(1,'小李','123')";
        int i = qr.update(sql);
        System.out.println(i);
        //添加数据
        //获取核心类对象
       /* QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句  并执行
        String sql = "insert into user values(null,'老王','789')";
        int i = qr.update(sql);
        System.out.println(i+"行 受影响");*/
        //删除数据
        //获取核心类对象
      /*  QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句  并执行
        String sql = "delete from user where id = 1";
        int i = qr.update(sql);
        System.out.println(i+"行 受影响");*/

      //改数据
        QueryRunner qr1 = new QueryRunner(C3P0Utils.getDataSource());
        String sql1= "update user set uname = '李飞' where id = 2";
        int i1 = qr.update(sql1);
        System.out.println(i1);
    }
}
