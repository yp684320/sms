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
import java.util.Map;

@WebServlet("/page")
public class PageServlet extends HttpServlet {
    private UserService userService = BeanFactory.newInstance(UserService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取用户需求的页数
        String pageNumber = request.getParameter("pageNumber");
        if (pageNumber==null) {
            pageNumber="1";
        }

        //每页显示条数
        int pageSize = 5;
        int pageNum = Integer.parseInt(pageNumber);

        //调用service方法 查询数据
        List<User> users =  userService.findByPage(pageNum,pageSize);
        //保存在request域中
        request.setAttribute("users",users);
        //总页数
        int total = userService.findTotal();
        int totalPage = (int) Math.ceil(total*1.0/pageSize);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageNumber",pageNumber);
        //展示交给jsp
        request.getRequestDispatcher("/list3.jsp").forward(request,response);
    }
}
