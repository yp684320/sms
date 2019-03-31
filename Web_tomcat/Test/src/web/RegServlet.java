package web;

import Service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过页面获取数据

        String sname = req.getParameter("sname");
        String pwd = req.getParameter("pwd");
        System.out.println("学生:"+sname+"密码:"+pwd);
        StudentService studentService = new StudentService();
        boolean reg = studentService.reg(sname, pwd);
        if (reg) {
            resp.sendRedirect("/test/login.html");
        }
    }
}
