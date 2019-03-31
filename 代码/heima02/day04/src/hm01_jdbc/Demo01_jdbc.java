package hm01_jdbc;
/*JDNC开发的六个步骤
   1,注册驱动
   2,获取连接
   3,获取执行sql语句对象
   4,执行sql语句
   5,处理结果集
   6,释放资源*/
import com.mysql.jdbc.Driver;

import java.sql.*;

public class Demo01_jdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1,注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      //2,获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_332", "root", "root");
        System.out.println(conn);
        //3,获取执行sql语句对象
        Statement stmt = conn.createStatement();
        //4,执行sql语句
        ResultSet rs = stmt.executeQuery("SELECT  pname,price FROM product2");
        //5处理结果集
        while (rs.next()) {
            String pname = rs.getString("pname");
            int price = rs.getInt("price");
            System.out.println(pname +" "+price);

        }
        //6,释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
