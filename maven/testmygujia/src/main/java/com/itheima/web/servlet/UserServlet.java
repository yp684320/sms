package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.MyBeanUtil;
import com.itheima.utils.UUIDUtil;
import com.itheima.web.vo.ResultVo;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Map;



@WebServlet("/user")
public class UserServlet extends BaseServlet {
    private UserService userService= BeanFactory.newInstance(UserService.class);
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //写注册逻辑

        //先做数据格式的检验
        String username = request.getParameter("username");
        //给个要求呗
        if(username==null||username.trim().length()>6||username.trim().length()<3){
            //返回错误信息

            //一开始规定 统一格式

            ResultVo vo = new ResultVo(ResultVo.CODE_FAILED, "长度必须在3~6之间", "");

            //返回的时候 必须json
            String s = JSONObject.fromObject(vo).toString();
            response.getWriter().print(s);

            return ;
        }



        //获取数据
        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();

        //封装对象
        /*try {
            BeanUtils.populate(user,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        MyBeanUtil.populate(user,parameterMap);
        //手动封装 一些数据
        user.setUid(UUIDUtil.getId());


        //调用service
        userService.regist(user);


        //返回结果
        ResultVo vo = ResultVo.success();

        //返回的时候 必须json
        String s = JSONObject.fromObject(vo).toString();
        response.getWriter().print(s);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //写登录的逻辑

        //获取账号密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调用service 查询用户
        User user=userService.login(username,password);

        //根据返回结果
        if(user==null){
            //账号密码错误

            fail("账号密码错误");
        }else{
            //将用户信息 存在session
            request.getSession().setAttribute("user",user);

            //成功额

            //将当前登录人的名字 写入cookie中
            Cookie cookie = new Cookie("name", URLEncoder.encode(user.getName(), "utf-8"));

            //设置时间
            cookie.setMaxAge(3600*24*15);

            //设置域名
            cookie.setDomain("itheima332.com");

            //整个项目都起作用
            cookie.setPath(request.getContextPath()+"/");

            //带回给浏览器
            response.addCookie(cookie);

            /*//纯粹测试
            //将当前登录人的名字 写入cookie中
            Cookie cookie1 = new Cookie("name1", URLEncoder.encode(user.getName(), "utf-8"));

            //设置时间
            cookie1.setMaxAge(3600*24*15);

            //设置域名
            cookie1.setDomain("itheima332.com");

            //整个项目都起作用
            cookie1.setPath(request.getContextPath()+"/");

            //带回给浏览器
            response.addCookie(cookie1);*/



            success();
        }


    }


    protected void currentInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前登录人信息

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if(user==null){
            noLogin();
        }else{
            //获取当前登录人的名字
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
