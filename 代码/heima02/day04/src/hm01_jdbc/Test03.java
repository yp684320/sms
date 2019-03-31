package hm01_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//3.	查询所有部门的名字，loc，员工数量和工资平均值 ()
public class Test03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {//获取连接
            conn = JdbcUtils.getConnection();
            //获取执行语句对象
            st = conn.createStatement();
            //执行语句
            String sql = "SELECT dname,loc,count(ename),AVG(sal) FROM emp e , dept d WHERE e.deptno = d.deptno GROUP BY e.deptno";
            rs = st.executeQuery(sql);
            //处理结果集
            while (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                int anInt = rs.getInt("count(ename)");
                String string = rs.getString("AVG(sal)");
                System.out.println(dname + " " + loc + " " + anInt + " " + string);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
}
