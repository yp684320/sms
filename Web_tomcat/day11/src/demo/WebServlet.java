package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@javax.servlet.annotation.WebServlet("/hello")
public class WebServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取提交方式
        String method = request.getMethod();
        System.out.println(method);
        //获取动态项目路径
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //获取远程访问者IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
