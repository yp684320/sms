package hm03_dengluzhuce.Servlet;

import hm03_dengluzhuce.Domain.User;
import hm03_dengluzhuce.Service.UserService;
import org.junit.Test;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

//    @Test
//    public void run(){
//        String username = "tom";
//        String password = "123";
//        //new user封装信息
//        User user = new User();
//        String username1 = user.getUsername();
//        String password1 = user.getPassword();
//        //调用 UserService 方法
//        UserService userService = new UserService();
//        boolean login = userService.login(user);
//        if (login) {
//            System.out.println(1);
//        } else {
//            System.out.println(0);
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //获取页面数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //new user封装信息
        User user = new User();
        String username1 = user.getUsername();
        String password1 = user.getPassword();
        //调用 UserService 方法
        UserService userService = new UserService();
        boolean login = userService.login(user);
        if (login) {
            resp.getWriter().println("登录成功");
        } else {
            resp.getWriter().println("登录失败");
        }

    }
}
