package anli.web;

import anli.domain.User;
import anli.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //////////////判断验证码  start  //////////////
        //获取提交的验证码  pamaCode来自login.jsp的验证码name属性
        String paramCode = request.getParameter("paramCode");
        //获取YanZhengMaServlet中设置的  sessionCode
        String sessionCode = (String) request.getSession().getAttribute("sessionCode");
        //验证码出来后立即销毁
        request.getSession().removeAttribute(sessionCode);
        //判空
        if (sessionCode == null) {
            request.getSession().setAttribute("msg","验证码只能使用一次");
            //重定向
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        //判断验证码是否为空
        if (paramCode==null||paramCode.trim().length()==0) {
            request.getSession().setAttribute("msg","请输入验证码");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        //判断输入验证码是否正确
        if (!paramCode.equalsIgnoreCase(sessionCode)){
            request.getSession().setAttribute("msg","验证码错误,请重新输入");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        ////////////验证码判断 end/////////
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用service方法
        UserService userService = new UserService();
        User user =  userService.login(username,password);
        //判断user是否为空
        if (user == null) {
            //为空  返回账号密码错误
            request.getSession().setAttribute("user", user);
            //重定向到登录界面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        } else {//保存用户状态  就是讲user存入session中
            request.getSession().setAttribute("user",user);
            response.getWriter().print("恭喜您:"+username+"登录成功");
            //重定向到主页
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        }

    }
}
