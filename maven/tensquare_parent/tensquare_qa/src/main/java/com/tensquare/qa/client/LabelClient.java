package com.tensquare.qa.client;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
//feign客户端需要调用哪个微服务,name就是微服务的名字
@FeignClient(name = "tensquare-base")
public interface LabelClient {

    //声明调用对方服务的哪些功能,本例是根据id查询标签
    //方法和基础微服务的Controller写法几乎一样
    //1. value需要完整的访问地址
    //2. @PathVariable必须写属性,而且就是占位符的名字,不能省略
    @RequestMapping(value = "label/{labelId}", method = RequestMethod.GET)
    public Result queryById(@PathVariable("labelId") String labelId);
}
