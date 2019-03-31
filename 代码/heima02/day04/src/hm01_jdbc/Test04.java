package hm01_jdbc;

import java.sql.*;

/*-- 4.  查询和Scott相同部门的员工姓名和雇用日期
SELECT ename,hiredate FROM emp  WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'Scott') ;*/
public class Test04 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //获取连接
        try {
            conn = JdbcUtils.getConnection();
            //获得执行语句对象
           stmt = conn.createStatement();
           //获得执行语句  执行
            String sql = "SELECT ename,hiredate FROM emp  WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'Scott')";
          rs = stmt.executeQuery(sql);
          //处理结果
            while (rs.next()) {
                String ename = rs.getString("ename");
                String hiredate = rs.getString("hiredate");
                System.out.println(ename +" "+hiredate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.closeResource(conn,stmt,rs);
        }
    }
}
