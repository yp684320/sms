package Service;

import Dao.StudentDao;
import Domain.Student;

import java.sql.SQLException;

public class StudentService {
    StudentDao studentDao = new StudentDao();
    //提供登录功能
    public Boolean login(String sname ,String pwd){

        //调用方法
        try {
            boolean b = studentDao.queryStudentBySnameAndPwd(sname, pwd);
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //提供注册方法


    public boolean reg(String sname,String pwd) {
        try {
            Boolean student = studentDao.updataStudent(sname, pwd);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
