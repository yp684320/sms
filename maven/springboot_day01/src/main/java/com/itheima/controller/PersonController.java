package com.itheima.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("person")
public class PersonController {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;
    @RequestMapping("test")
    @ResponseBody
    public String Test(){
        return "姓名" + name + "年龄" + age;
    }
}
