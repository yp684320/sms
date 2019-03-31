package hm01_daima;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.C3P0Utils;

import java.sql.SQLException;

//ScalarHandler：它是用于单数据。例如select count(*) from 表操作。
public class Demo05 {
    public static void main(String[] args) throws SQLException {
     //获取核心类对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句 并执行
        String sql = "select count(*) from product";
        Object o = qr.query(sql, new ScalarHandler<>());
        System.out.println(o);

    }
}
