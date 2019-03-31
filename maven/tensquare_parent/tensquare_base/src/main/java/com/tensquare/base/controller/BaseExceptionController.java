package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//声明异常处理器Controller
@ControllerAdvice
public class BaseExceptionController {

    //声明异常处理的处理器(Controller方法)
    @ExceptionHandler
    //要声明参数,参数就是要处理的异常
    @ResponseBody
    public Result handlerException(Exception e) {

        //可以像之前学习的全局异常处理器HandlerExceptionResolver一样进行处理

        //打印异常信息
        e.printStackTrace();


        //返回合理的异常信息
        return new Result(false, StatusCode.ERROR, "测试异常处理方式");
    }
}
