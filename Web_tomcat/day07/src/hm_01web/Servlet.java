package hm_01web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行doPost方法");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+" "+password);

        String name = req.getParameter("name");
        resp.getWriter().println(username + password+name);
    }
}
