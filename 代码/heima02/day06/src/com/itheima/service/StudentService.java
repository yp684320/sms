package com.itheima.service;
import com.itheima.Student;
import com.itheima.StudentDao;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
        //查询所有数据的方法

        public List<Student> query(){
            StudentDao studentDao = new StudentDao();
            List<Student> list = null;
            try {
                list = studentDao.query();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;

        }


    public String insert(int id,String name) {

            StudentDao studentDao = new StudentDao();
        try {
            int flag = studentDao.inSert(id,name);
            if (flag == 1) {
                return "添加成功";
            } else {
                return"添加失败";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "出现异常";
    }
}
