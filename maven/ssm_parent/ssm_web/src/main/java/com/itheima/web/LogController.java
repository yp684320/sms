package com.itheima.web;

import com.itheima.domain.SysLog;
import com.itheima.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@Aspect
public class LogController {
    @Autowired
    LogService logService;
    @Autowired
    HttpServletRequest request;
    //切入点
    @Pointcut("execution(* com.itheima.web.*.*(..))")
    public void pointcut(){};
    //通知  使用前置通知
    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        /*private Long id;
        private String visitTime;
        private String username;
        private String ip;
        private String method;*/
        SysLog sysLog = new SysLog();
        //id通过序列获取
        //visitTime;  访问时间
        sysLog.setVisitTime(new Date());
        //username  用户名
        //获取securityContext对象
        SecurityContext securityContext = SecurityContextHolder.getContext();
        //获取认证对象
        Authentication authentication = securityContext.getAuthentication();
        //获取用户对象
        Object principal = authentication.getPrincipal();
        User user = (User) principal;
        sysLog.setUsername(user.getUsername());
        //ip;IP地址
        String ip = request.getRemoteAddr();
        sysLog.setIp(ip);
        // method;方法
        //得到的代理的真是对象
        Object o = joinPoint.getTarget();
        //请求的controller的权限类名
        String className = o.getClass().getName();
        //拦截的方法对象
        Signature signature = joinPoint.getSignature();
        //拦截方法的名称
        String methodName = signature.getName();
        //com.itheima.controller.UserController.findAll
        sysLog.setMethod(className + "." + methodName);

        //保存日志操作
        logService.save(sysLog);



    }

}
