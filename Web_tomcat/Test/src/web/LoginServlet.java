package web;

import Service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        int count = 0;
        //将这个值存放到ServletContext中
        this.getServletContext().setAttribute("count",count);
    }

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
        //调用登录方法  判断是否登录成功
        Boolean login = studentService.login(sname, pwd);
        System.out.println("登录"+login);

        if (login) {
            int count = (int) this.getServletContext().getAttribute("count");
            count++;
            this.getServletContext().setAttribute("count", count);
            resp.sendRedirect("/test/count");
        }

    }
}
