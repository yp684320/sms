package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountServlet extends HttpServlet {
//    @Override
//    public void init() throws ServletException {
//        int count = 0;
//        //将这个值存放到ServletContext中
//        this.getServletContext().setAttribute("count",count);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//       int  count = (int) this.getServletContext().getAttribute("count");
//            count++;
//            this.getServletContext().setAttribute("count", count);



        resp.setContentType("text/html;charset=UTF-8");
        int count = (int) this.getServletContext().getAttribute("count");
        resp.getWriter().println("<h1 >您是第"+ count +"位登录成功的客户!<h1 >");

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
