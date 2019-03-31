package web;

import domain.KW;
import net.sf.json.JSONArray;
import org.junit.Test;
import service.KWService;
import utils.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/kw")
public class KWServlet extends HttpServlet {
    private KWService kwService = BeanFactory.newInstance(KWService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取请求参数
        String value = request.getParameter("value");
        //调用service方法查询
        List<KW> kws = kwService.findAll(value);
        //返回  装换为json
        String s = JSONArray.fromObject(kws).toString();
        response.getWriter().print(s);


    }
    //测试Servlet 到 dao 是否正确
    @Test
    public void run(){
        List<KW> kws = kwService.findAll("华为");
        for (KW kw : kws) {
            System.out.println(kw.getName());
        }
    }

}
