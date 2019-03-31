package hm01_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//5.  查询工资比公司平均工资底的员工的员工号，姓名和工资。
public class Test05 {
    public static void main(String[] args) throws SQLException {
        //获取连接
        Connection conn = JdbcUtils.getConnection();
        //获得语句执行对象
        Statement stmt = conn.createStatement();
        //执行语句
        String sql= "select empno,ename ,sal from emp where sal < (select avg(sal) from emp ) ";
        ResultSet rs = stmt.executeQuery(sql);
        //处理结果集
        while (rs.next()) {
            String empno = rs.getString("empno");
            String ename = rs.getString("ename");
            String sal = rs.getString("sal");
            System.out.println(empno+" "+ename+" "+sal);
        }
        //释放资源
        JdbcUtils.closeResource(conn,stmt,rs);
    }
}
