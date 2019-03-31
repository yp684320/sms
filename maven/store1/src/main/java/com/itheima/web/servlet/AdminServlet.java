package com.itheima.web.servlet;

import com.itheima.domain.Cart;
import com.itheima.domain.Category;
import com.itheima.exception.CategoryHasProductException;
import com.itheima.service.CategoryService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends BaseServlet {
    private CategoryService categoryService = BeanFactory.newInstance(CategoryService.class);
    protected void categoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接受请求
		调用service 查询所有分类信息
		返回............*/
        //调用service方法
        List<Category> categories = categoryService.findAll();
        //把结果返回
        success(categories);
    }
    protected void delCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //接收参数
        String cid = request.getParameter("cid");
        //调用service 删除数据
        try {
            categoryService.del(cid);
        } catch (CategoryHasProductException e) {
           fail("该分类下存在商品不能删除");
        }
        success();

    }
    protected void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String cname = request.getParameter("cname");
        // 验证格式是否正确
        if (cname == null || cname.trim().length() > 6 || cname.trim().length() < 3) {
            //返回错误信息
            fail("名字长度必须在4~6之间");
            return;
        } else {
            // 否则
            //封装对象
            Category category = new Category();
            category.setCid(UUIDUtil.getId());
            category.setCname(cname);
            //调用service 保存
            categoryService.save(category);
            //返回成功信息
            success(category);

        }



    }
    protected void categoryInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String cid = request.getParameter("cid");
        //调用service 查询
       Category category =  categoryService.findOne(cid);
       // System.out.println(category.getCname());  测试 是否从数据库查到数据
        //返回数据
        success(category);

    }
    protected void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String cname = request.getParameter("cname");
        String cid = request.getParameter("cid");
        // 验证格式是否正确
        if (cname == null || cname.trim().length() > 6 || cname.trim().length() < 3) {
            //返回错误信息
            fail("名字长度必须在4~6之间");
            return;
        } else {
            // 否则
            //封装对象
            Category category = new Category();
            category.setCid(cid);
            category.setCname(cname);
            //调用service 保存
            categoryService.update(category);
            //返回成功信息
            success(category);

        }

    }
}
