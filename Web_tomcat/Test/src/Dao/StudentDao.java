package Dao;

import Domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;
import utils.C3P0Utils;

import java.sql.SQLException;

public class StudentDao {
    //验证是否与数据库正常连接
    @Test
    public void run() throws SQLException {
        boolean tom = queryStudentBySnameAndPwd("Tom", "123");
        System.out.println(tom);
    }
    //创建QueryRunnable对象
    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
    //通过名字 密码查询数据
    public boolean queryStudentBySnameAndPwd(String sname,String pwd) throws SQLException {

        //编写sql语句
        String sql = "select * from student where sname = ? and pwd = ?";
        //执行语句
        Student user = qr.query(sql, new BeanHandler<>(Student.class), sname, pwd);
        return user != null;
    }
    //添加数据
    public Boolean updataStudent(String sname,String pwd) throws SQLException {
        //编写sql语句
        String sql = "insert into student values(null,?,?)";
        //执行语句
        int update = qr.update(sql, sname, pwd);
        if (update > 0) {
            return true;
        }
        return false;
    }
}
