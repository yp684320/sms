package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.MyBeanUtil;
import com.itheima.utils.ResponseUtil;
import com.itheima.utils.UUIDUtil;
import com.itheima.web.vo.ResultVo;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
    private UserService userService = BeanFactory.newInstance(UserService.class);

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //注册逻辑
        //先做数据格式的检验
        String username = request.getParameter("username");
        //判断
        if (username == null || username.trim().length() > 6 & username.trim().length() < 3) {
            //返回错误信息

            //一开始规定 统一格式
            ResultVo vo = new ResultVo(ResultVo.CODE_FAILED, "长度必须在3~6之间", "");
            //返回的时候  必须json
            String s = JSONObject.fromObject(vo).toString();
            response.getWriter().print(s);
        }

        //获取请求参数
//        System.out.println("测试");
        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();

        //封装对象
        /*try {
            BeanUtils.populate(user,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        MyBeanUtil.populate(user, parameterMap);
        //手动封装 一些数据
        user.setUid(UUIDUtil.getId());


        //调用service
        userService.regist(user);
//        System.out.println("注册成功");

        //返回结果
        ResultVo vo = ResultVo.success();

        //返回的时候 必须json
        String s = JSONObject.fromObject(vo).toString();
        response.getWriter().print(s);


    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //测试是否进来
        //System.out.println("1");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //测试是否获取到数据
        //System.out.println(username);
        //调用service查询
        User user = userService.login(username, password);

        //根据返回结果
        //测试是否有返回数据
        //System.out.println(user);

        if (user == null) {
            //账户密码错误
            fail("账号密码错误");
        } else {


            //将用户信息存入session中
            request.getSession().setAttribute("user",user);
            //将当前用户名字写入cookie中
            Cookie cookie = new Cookie("name", URLEncoder.encode(user.getName(),"UTF-8"));
            //设置时间
            cookie.setMaxAge(3600*24*15);
            //设置域名
            cookie.setDomain("itheima332.com");
            //整个项目都起作用
            cookie.setPath(request.getContextPath()+"/");
            //带回给浏览器
            response.addCookie(cookie);

           /* ResultVo vo = new ResultVo(ResultVo.CODE_SUCCESS,"");

            response.getWriter().print(JSONObject.fromObject(vo).toString());*/
           success();



        }

    }

    protected void currentInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //获取当前用户信息
       // System.out.println(33);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
       // System.out.println(user);
        //判断用户是否存在
        if (user == null) {
            noLogin();
        } else {
            //用户存在
            //获取用户的名字
            String name = user.getName();
            success(name);
        }
    }
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //销毁session
        request.getSession().invalidate();
        success();
    }
}
