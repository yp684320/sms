package hm_02dengluanli.Servlet;

import hm_02dengluanli.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取页面数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户:"+username +"密码:"+password);
        //判断是否注册成功
        UserService userService = new UserService();

        boolean reg = userService.reg(username, password);
        System.out.println("注册:"+reg);

        if (reg) {
            resp.sendRedirect("/day08/login.html");
        }


    }
}

