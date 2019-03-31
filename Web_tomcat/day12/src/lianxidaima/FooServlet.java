package lianxidaima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/foo")
public class FooServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Cookie cookie = new Cookie("foo", "123");
        //希望时间久一点  一周
        cookie.setMaxAge(7*24*3600);
        //设置路径
        cookie.setPath(request.getContextPath()+"/");
        response.addCookie(cookie);
        response.getWriter().print("测试时间");


    }
}
