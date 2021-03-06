package servlet;


import domain.PageBean;
import domain.User;
import service.UserService;
import utils.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findByPage1")
public class PageServlet1 extends HttpServlet {
    private UserService userService= BeanFactory.newInstance(UserService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //要求用户 必须告诉第几页数据
        String pageNumber = request.getParameter("pageNumber");
        if(pageNumber==null){
            pageNumber="1";
        }
        //每页显示几条
        int pageSize=5;
        int pageNum=Integer.parseInt(pageNumber);


        /*//调用servicee查询
        List<User> users=userService.findByPage(pageNum,pageSize);

        //传入request
        request.setAttribute("users",users);


        //还要总页码
        int total=userService.findTotal();
        int totalPage= (int) Math.ceil(total*1.0/pageSize);

        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageNumber",pageNumber);*/

        PageBean<User> pb=userService.findByPage1(pageNum,pageSize);

        request.setAttribute("pb",pb);

        //交给jsp
        request.getRequestDispatcher("/list4.jsp").forward(request,response);

    }
}
