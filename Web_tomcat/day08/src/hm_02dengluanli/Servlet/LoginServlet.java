package hm_02dengluanli.Servlet;

import hm_02dengluanli.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取页面数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户:" + username + "密码:" + password);
        //判断是否登录成功
        UserService userService = new UserService();

        boolean login = userService.login(username, password);
        System.out.println("登录:" + login);

    }
}
