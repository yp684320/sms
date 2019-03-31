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

@WebServlet("/con")
public class ConditionServlet extends HttpServlet {
    private UserService userService = BeanFactory.newInstance(UserService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //尝试获取数据
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        //调用service方法查询  封装到list集合
        List<User> users =  userService.findByCondition(sex,address);
        //数据 保存到 request域中
        request.setAttribute("users",users);
        request.setAttribute("sex",sex);
        request.setAttribute("address",address);
        //展示交给jsp
        request.getRequestDispatcher("/list2.jsp").forward(request,response);
    }
}
