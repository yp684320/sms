package hm_01Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/download1")
public class Download1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //获取管理者
        ServletContext context = this.getServletContext();
        //获取请求参数
        String name = request.getParameter("name");

        //设置Content-Type头   设置当前文件的格式
        String mimeType = context.getMimeType(name);
        response.setHeader("Content-Type",mimeType);
        //设置Content-Disposition 头
        response.setHeader("Content-Disposition","attachment;name="+name);
        //获取输入流对象
        InputStream is = context.getResourceAsStream("/WEB-INF/download/"+name);
        //获取输出流对象
        ServletOutputStream out = response.getOutputStream();

        //读写数据
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = is.read(b))!=-1) {
            out.write(b,0,len);
        }
        //释放资源
        out.close();
        is.close();
    }
}
