package hm01_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 8. 	查询管理者是King的员工姓名和工资
public class Test08 {
    public static void main(String[] args) throws SQLException {
        //获取连接
        Connection conn = JdbcUtils.getConnection();
        //获得执行语句对象
        Statement statement = conn.createStatement();
        //执行语句
        String sql = "select ename,sal from emp where mgr = (select empno from emp where ename = 'King' )";
        ResultSet rs = statement.executeQuery(sql);
        //处理结果集
        while (rs.next()) {
            String ename = rs.getString("ename");
            String sal = rs.getString("sal");
            System.out.println(ename+" "+sal);
        }
        //释放资源
        JdbcUtils.closeResource(conn,statement,rs);
    }
}
