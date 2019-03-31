package hm01_jdbc;

import java.sql.*;

//1. 求最高薪水的员工信息
public class Test01 {
    public static void main(String[] args) throws SQLException {
        //1,获取连接
        Connection conn = JdbcUtils.getConnection();
        //2,获取sql语句的执行对象
        Statement stmt = conn.createStatement();
        //3,执行sql语句
        String sql= "SELECT *,max(sal) FROM  emp";
        ResultSet rs = stmt.executeQuery(sql);
        //4,处理结果
        while (rs.next()) {
            int empno = rs.getInt("empno");
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            String hiredate = rs.getString("hiredate");
            String sal = rs.getString("sal");
            String comm = rs.getString("comm");
            int deptno = rs.getInt("deptno");
            String s = rs.getString("max(sal)");
            System.out.println(empno+" "+ename+" "+job+" "+mgr+" "+hiredate+" "+sal+" "+comm+" "+deptno+" "+s);
        }
        System.out.println();
        //5,释放资源
        JdbcUtils.closeResource(conn,stmt,rs);


    }
}
