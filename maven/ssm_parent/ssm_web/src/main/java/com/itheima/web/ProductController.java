package com.itheima.web;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    //分页助手  分页查询
    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(value ="pageNum" ,required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = false, defaultValue = "5") Integer pageSize){
        //准备数据
        PageInfo<Product> pageInfo = productService.findByPageHelper(pageNum ,pageSize);
        //创建MadeAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("pageInfo",pageInfo);
        //条转到指定页面
        modelAndView.setViewName("product-list");
        //返回数据
        return modelAndView;
    }
    //分页查询
    @RequestMapping("/findAll3")
    public ModelAndView findAll3(
            @RequestParam(value ="pageNum" ,required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = false, defaultValue = "5") Integer pageSize){
        //准备数据
        PageBean<Product> pageBean = productService.findByPage(pageNum ,pageSize);
        //创建MadeAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("pageBean",pageBean);
        //条转到指定页面
        modelAndView.setViewName("product-list");
        //返回数据
        return modelAndView;
    }

    @RequestMapping("/findAll2")//原来的查询
    public ModelAndView findAll2(){
        //准备数据
       List<Product> products = productService.findAll();
       //创建MadeAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("products",products);
        //条转到指定页面
        modelAndView.setViewName("product-list");
        //返回数据
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:/product/findAll";
    }
    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        modelAndView.addObject("product",product);
        modelAndView.setViewName("product-update");
        return modelAndView;
    }
    @RequestMapping("/update")
    public String update(Product product){
        //更新操作
       productService.update(product);
       //请求全查
        return "redirect:/product/findAll";
    }
    @RequestMapping("/delOne")
    public String delOne(Integer id){
        //删除操作
        productService.delById(id);
        //请求查询所有
        return "redirect:/product/findAll";
    }
    @RequestMapping(value = "/delMany")
    public String delMany(Integer[] ids){
        //删除数据
       productService.delMany(ids);
        //System.out.println(Arrays.toString(ids));
        //请求全查
        return "redirect:/product/findAll";
    }
}
