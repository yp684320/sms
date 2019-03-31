package hm_03download;

import hm_01zhujie.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "Download",urlPatterns = "/download")
public class DownloadServlet extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        String filename = req.getParameter("filename");
        //完成文件下载
        //设置Content-Type头
        String type = this.getServletContext().getMimeType(filename);
        resp.setHeader("Content-Type",type);
        //设置Content-Disposition头
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        //设置文件的inputstream
        String realPath = this.getServletContext().getRealPath("/download/" + filename);
        InputStream is = new FileInputStream(realPath);
        //获取resp的输出流
        ServletOutputStream os = resp.getOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = is.read(b))!= -1) {
            os.write(b,0,len);
        }
        is.close();
    }
}
