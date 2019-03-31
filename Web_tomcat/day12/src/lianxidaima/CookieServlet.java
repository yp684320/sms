package lianxidaima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取Cookie对象
        // Cookie[] cookies = request.getCookies();
        //判断cookie是否存在
//        if (cookies!= null) {
//            //遍历
//            for (Cookie cookie : cookies) {
//                System.out.println("cookie的名字:"+cookie.getName()+"cookie的值:"+cookie.getValue());
//            }
//        }
        //new cookie对象
        Cookie cookie = new Cookie("job","xiaoshou");
        //设置路径
        cookie.setPath(request.getContextPath()+"/xiaoshou/");
        response.addCookie(cookie);





    }
}
