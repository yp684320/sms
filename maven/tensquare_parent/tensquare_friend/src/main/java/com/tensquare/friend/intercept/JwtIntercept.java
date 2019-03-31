package com.tensquare.friend.intercept;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtIntercept implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    //之前,在请求进入Controller方法(处理器)之前先执行这个方法
    //如果返回true,放行,往下执行,就执行Controller方法(处理器)
    //如果返回false,拦截,就不往下执行,Controller方法就不会执行了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在进行删除之前,需要先判断用户是否是管理员权限
        //使用jwt进行鉴权
        //前后端约定：前端请求微服务时需要添加头信息Authorization, 内容为Bearer + 空格 + token
        //1. 从请求头获取token,就是获取请求头中的Authorization值
        String header = request.getHeader("Authorization");

        //2. 判断获取到的值是否为空
        if (header == null || "".equals(header)) {
            // 如果为空表示用户未登录
            return true;
        }

        //3. 判断获取到的值是否合法,判断是否以Bearer + 空格开头
        if (!header.startsWith("Bearer ")) {
            //如果不合法,表示用权限错误
            return true;
        }

        //4. 获取token的值,进行解析,使用jwtutil工具类进行解析
        String token = header.substring(7);

        try {
            Claims claims = jwtUtil.parseJWT(token);

            //5.判断解析的claims是否为空
            if (claims == null) {
                //如果为空,表示权限错误
                return true;
            }


            //如果鉴权获取的claims没有问题,需要把结果claims传递给Controller的方法

            //可以使用两种方式
            //1. 因为拦截器和Controller方法是一个线程ThreadLocal

            //2. 因为拦截器和Controller方法是一个请求,可以使用request
            request.setAttribute("claims", claims);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    //之中,进入了Controller方法,并且执行了方法的逻辑,但是再返回结果(ModelAndView),执行该方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //之后,进入了Controller方法,执行了方法逻辑,返回了结果(ModelAndView)之后,所有的事都做完,最后执行这个方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
