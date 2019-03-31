package web;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/*
注册登录
 准备工作:
   1,创建数据库  创建数据库表
   2,写html文件
   3,写Servlet代码  分层开发
  */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取请求参数
        //参数较多时 用map集合返回
        Map<String, String[]> map = request.getParameterMap();

        //封装成一个User对象
        User user = new User();

        //在beanutils中提供  自动封装
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用serveice方法  保存用户信息
        UserService userService = new UserService();
        userService.regist(user);
        //重定向
        response.sendRedirect(request.getContextPath()+"/login.htm");
    }


}
