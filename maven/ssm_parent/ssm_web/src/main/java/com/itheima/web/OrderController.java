package com.itheima.web;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    //查询所有
    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        //准备数据
      List<Order> orders = orderService.findAll();
      //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("orders",orders);
        //指定跳转页面
        modelAndView.setViewName("order-list");
        //返回ModelAndView对象
        return modelAndView;

    }
    //保存数据回显
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){

        //准备数据
        List<Product> products = productService.findAll();

        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("products",products);
        //指定跳转页面
        modelAndView.setViewName("order-add");
        //返回ModelAndView对象
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(Order order){
        //准备数据
     orderService.save(order);
     //查询所有
        return "redirect:/order/findAll";
    }
}
