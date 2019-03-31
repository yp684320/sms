package lianxidaima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/kill")
public class KillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //删除 cookie  必须同名 通路径  这样后面的就会把前面的覆盖  时间设置为0  就是创建马上就小时
        Cookie cookie = new Cookie("foo", "");
        cookie.setPath(request.getContextPath()+"/");
        //设置时间为0
        cookie.setMaxAge(0);

    }
}
