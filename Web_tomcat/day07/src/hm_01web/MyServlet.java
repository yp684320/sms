package hm_01web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("执行doGet()方法");
////        String username = req.getParameter("username");
////        String password = req.getParameter("password");
////        System.out.println(username+" "+password);
        doPost(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, IOException {
        req.setCharacterEncoding("UTF-8");
        // System.out.println("执行doPost()方法");
        //获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+" "+password);
        //获取爱好
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies) );
        // 获取所有数据 遍历map
        Map<String, String[]> allDatea= req.getParameterMap();
        for (Map.Entry<String, String[]> entry : allDatea.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(Arrays.toString(entry.getValue()));
        }

    }
}

