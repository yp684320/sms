package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findByPage")
public class PageServlet extends HttpServlet {
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


        //调用servicee查询
        List<User> users=userService.findByPage(pageNum,pageSize);

        //传入request
        request.setAttribute("users",users);


        //还要总页码
        int total=userService.findTotal();
        int totalPage= (int) Math.ceil(total*1.0/pageSize);

        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageNumber",pageNumber);



        //交给jsp
        request.getRequestDispatcher("/list3.jsp").forward(request,response);

    }
}
