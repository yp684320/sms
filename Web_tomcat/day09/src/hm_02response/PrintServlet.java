package hm_02response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet(name = "PrintServlet",urlPatterns = "/print")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  resp.setCharacterEncoding("UTF-8");//此处设置编码  给浏览器的数据正确  但是我们看到的仍是乱码
        // resp.setHeader("Content-type","text/html;charset=UTF-8");//俩处同事设置编码 才能处理乱码嘛问题
        resp.setContentType("text/html;charset = UTF-8");//处理乱码问题常用此种方法
        String data = "hh 你好";
        String data1 = "hhh 都很好";
        //获取字节输出流对象
        //OutputStream out = resp.getOutputStream();

        // out.write(data.getBytes());
        //获取字符输出流对象
        PrintWriter print= resp.getWriter();
        print.write(data1);
    }
}
