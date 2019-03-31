package hm_01Servlet;

import utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/down")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //获取管理
        ServletContext context = this.getServletContext();
        //获取请求参数
        String filename = request.getParameter("filename");

        //回写content-type头  设置当前文件的格式
        String mimeType = context.getMimeType(filename);
        response.setHeader("Content-Type",mimeType);
        // 回写content-disposition头  告诉这是一个附件不是用来代开的
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        // response.setHeader("Content-Disposition","attachment;filename="+ DownLoadUtils.getName(request.getHeader("user-agent"),filename));
        // 获取输入流对象
        InputStream is = context.getResourceAsStream("/WEB-INF/download/"+filename);
        //获取response的输出流对象
        ServletOutputStream out = response.getOutputStream();
        //读写数据
        byte[] b=new byte[1024];
        int len=0;
        while ((len = is.read(b))!=-1) {
            out.write(b,0,len);
        }
        out.close();
        is.close();



    }
}
