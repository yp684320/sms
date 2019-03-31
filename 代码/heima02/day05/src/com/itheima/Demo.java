package com.itheima;

import com.itheima.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update account set  money = money - ? where name = 'tom'";
        String sql1 = "update account set  money = money + ? where name = 'rose'";
        int i = qr.update(sql,200);
        int i1 = qr.update(sql1, 200);
        System.out.println(i+" ×ªÕË³É¹¦");


    }
}
