package lianxidaima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

@WebServlet("/last")
public class LastServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        /*判断是否是第一次访问
         * */
        //判断有没有带cookie
        Cookie lastTimeCookie = null;
        Cookie[] cookies = request.getCookies();
        //判断
        if (cookies != null) {
            //如果cookie存在
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("last")) {
                    lastTimeCookie = cookie;
                    break;
                }
            }
        }
        if (lastTimeCookie != null) {
            //判断有  只要取出时间  回写给你
            String value = lastTimeCookie.getValue();
            Date date = new Date(Long.parseLong(value));
            response.getWriter().print("您上次访问的时间是:" + date.toLocaleString());
        }
        else {//没有  就是第一次发访问
            response.getWriter().print("您是第一次访问");
        }
        // 无论都要设置一个cookie给浏览器  value值就是当前时间
        Cookie last = new Cookie("last", new Date().getTime()+"");
        response.addCookie(last);

    }
}
