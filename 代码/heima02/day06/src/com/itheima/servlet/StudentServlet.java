package com.itheima.servlet;
import com.itheima.service.StudentService;;

public class StudentServlet {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        String name = "Àî»ª";
        String flag = studentService.insert(0,name);
        System.out.println(flag);



    }
}
