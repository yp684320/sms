package com.itheima;
import org.apache.commons.dbutils.QueryRunner;
import java.sql.Connection;
import java.sql.SQLException;
//此处有异常就抛异常
public class AccountDao {
    QueryRunner qr = new QueryRunner();
    public void accoutOut(Connection connection, String outName, double money) throws SQLException {
        //获取执行对象

            String sql_out = "update account set  money = money - ? where name = ?";
            qr.update(connection, sql_out, money, outName);

    }


    public void accountIn(Connection connection, String inName, double money) throws SQLException {

             String sql_in = "update account set  money = money + ? where name = ?";
             qr.update(connection, sql_in, money, inName);

    }
}
