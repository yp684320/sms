package com.itheima.web.servlet;

import com.itheima.utils.BeanFactory;
import com.itheima.web.vo.ResultVo;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);


        Cookie cookie = new Cookie("test", "123");
        response.addCookie(cookie);
        //response.getWriter().print("hello world");
        //一定一个json格式的字符串


        //规定 每次返回的不管啥样的数据   都包装到 resultvo对象

        ResultVo vo = new ResultVo(ResultVo.CODE_SUCCESS, "helloworld", "返回成功");


        //写回的  json工具类转换
        String s = JSONObject.fromObject(vo).toString();
        response.getWriter().print(s);

    }
}
