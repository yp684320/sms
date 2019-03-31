package hm01_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 6.  查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
public class Test06 {
    public static void main(String[] args) throws SQLException {
        //获取连接
        Connection conn = JdbcUtils.getConnection();
        //获得执行语句对象
        Statement st = conn.createStatement();
        //执行语句
        String sql= "select empno,ename from emp where deptno = (select deptno from emp where ename like '%u%') ";
        ResultSet rs = st.executeQuery(sql);
        //处理结果集
        while (rs.next()) {
            String empno = rs.getString("empno");
            String ename = rs.getString("ename");
            System.out.println(empno+" "+ename);
        }
        //释放资源
        JdbcUtils.closeResource(conn,st,rs);
    }
}
