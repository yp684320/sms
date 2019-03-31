package com.itheima.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {
    @RequestMapping(value = "/{id}.html",method = RequestMethod.GET)
    public String find(@PathVariable(value = "id") String id){
        System.out.println("获取地址参数"+id+"去数据库查询");
        return "success";
    }
    @RequestMapping(value = "/{id}.html",method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") String id){
        System.out.println("获取地址参数"+id+"去数据库做删除");
        return "success";
    }

    @RequestMapping(value = "/{id}.html",method = RequestMethod.PUT)
    public String update(@PathVariable(value = "id") String id){
        System.out.println("获取地址参数"+id+"去数据库做修改");
        return "success";
    }
}
