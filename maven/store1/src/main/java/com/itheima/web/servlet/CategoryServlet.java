package com.itheima.web.servlet;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.utils.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.itheima.web.vo.ResultVo.success;

@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = BeanFactory.newInstance(CategoryService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        /*接受请求
		调用service 查询所有分类信息
		返回............*/
        //调用service方法
        List<Category> categories = categoryService.findAll();
        //把结果返回
        success(categories);
    }
}
