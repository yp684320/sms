package com.itheima.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class TestController {
    @RequestMapping("test")
    @ResponseBody
    public String Test(){
        return "springboot 访问成功";
    }
}
