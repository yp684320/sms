package servlet;

import domain.User;
import service.UserService;
import utils.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAll")
public class UserServlet extends HttpServlet {
    private UserService userService= BeanFactory.newInstance(UserService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //接受请求参数

        //调用service 方法 返回list集合
        List<User> users = userService.findAll();

        //把数据封装到request 域中
        request.setAttribute("users",users);

        //请求转发到list.jsp
        request.getRequestDispatcher("/list1.jsp").forward(request,response);

    }
}
