package com.tensquare.base.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//十次方项目不使用这种方式处理异常
//以前可以使用SpringMVC提供的全局异常处理器
public class MyHandlerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {

        //对获取到的异常 Exception ex进行判断(预期异常和运行时异常)

        //使用短信或邮件通知给相关人员


        //还需要给用户一个友好的提示
        //需要封装modelAndView进行返回


        return null;
    }
}
