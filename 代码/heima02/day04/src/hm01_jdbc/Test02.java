package hm01_jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//2. 求多于平均薪水的员工信息
public class Test02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = JdbcUtils.getConnection();
            //获取执行语句对象
            st = conn.createStatement();
            //执行语句
            String sql = "SELECT *  FROM emp WHERE sal >(SELECT AVG(sal) FROM emp)";
            rs = st.executeQuery(sql);
            //处理结果集
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                String hiredate = rs.getString("hiredate");
                String sal = rs.getString("sal");
                String comm = rs.getString("comm");
                int deptno = rs.getInt("deptno");
                System.out.println(empno+" "+ename+" "+job+" "+mgr+" "+hiredate+" "+sal+" "+comm+" "+deptno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //释放资源
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
}
