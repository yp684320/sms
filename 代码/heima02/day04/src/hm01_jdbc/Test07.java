package hm01_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//- 7. 	查询在部门的loc为 DALLAS 的部门工作的员工的员工号，
public class Test07 {
    public static void main(String[] args) throws SQLException {
       //获取连接
        Connection conn = JdbcUtils.getConnection();
        //获得执行语句对象
        Statement st = conn.createStatement();
        //执行语句
        String sql = "select empno from emp e,dept d where e.deptno = d.deptno and loc = (select loc from dept where loc ='DALLAS' ) ";
        ResultSet rs = st.executeQuery(sql);
        //处理结果集
        while (rs.next()) {
            int empno = rs.getInt("empno");
            System.out.println(empno);
        }

        //释放资源
        JdbcUtils.closeResource(conn,st,rs);
    }
}
