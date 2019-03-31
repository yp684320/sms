import oracle.jdbc.driver.OracleTypes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class TestJDBC {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@192.168.47.128:1521:orcl";
    String username = "scott";
    String password = "tiger";
    Connection connection;
    PreparedStatement pst;
    CallableStatement cst;
    ResultSet rs;
    @Before
    public void init() throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName(driver);
        //'获取连接
         connection = DriverManager.getConnection(url, username, password);
    }
    /*执行存储函数
    * {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}
     *  create or replace function getYearSalFun(eno in number) return number
    * */
    @Test
    public void testFunction() throws SQLException {
      /*  //sql 语句
        String sql = "{?= call getYearSalFun(?)}";
        //创建statement对象
        cst = connection.prepareCall(sql);
        //设置占位符   输入占位符
        cst.setInt(2,7788);
        //设置输出占位符
        cst.registerOutParameter(1, OracleTypes.NUMBER);
        //执行sql语句
        cst.executeUpdate();
        //处理结果集
        int yearSal = cst.getInt(1);
        System.out.println(yearSal);*/

    }
    @Test
    public void test() throws SQLException {
        String sql = "select * from emp";
         pst = connection.prepareStatement(sql);
         rs = pst.executeQuery();
         while(rs.next()){
             System.out.println(rs.getInt("empno")+":"+rs.getString("ename"));

         }

    }
    /**
     * 关闭资源
     */
    @After
    public void after() throws SQLException {
        if(rs != null){
            rs.close();
        }
        if(pst != null){
            pst.close();
        }
        if(cst != null){
            cst.close();
        }
        if(connection != null){
            connection.close();
        }
    }
}
