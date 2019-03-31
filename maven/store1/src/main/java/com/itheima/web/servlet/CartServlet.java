package com.itheima.web.servlet;

import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends BaseServlet {
    private ProductService productService = BeanFactory.newInstance(ProductService.class);
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String pid = request.getParameter("pid");
        int count = Integer.parseInt(request.getParameter("count"));

        if (count > 10) {
            fail("库存不足");
        } else {
            Product product = productService.findOne(pid);
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCount(count);
            //购物车对象
            Cart cart = getCart(request);
            //添加到购物车
            cart.addItem(cartItem);
            //返回信息
            success();
        }
    }
    //展示提交购物车页面
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //获取cart
        Cart cart = getCart(request);
        //返回
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"cid", "is_hot", "market_price", "pdate", "pdesc", "pflag"});
        success(cart,jsonConfig);
    }
//删除购物项
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接受请求
	根据pid删除*/
        String pid = request.getParameter("pid");
        //获取当前session中cart对象
        Cart cart = getCart(request);
        cart.removeItrm(pid);
        success();
    }
    //清空购物车
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前session中的cart
        Cart cart = getCart(request);
        //清空购物车
        cart.clear();
        success();
    }

    private Cart getCart(HttpServletRequest request) {
        //保证cart对象  一次会话中只有一个
        //先去当前的session中获取
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        //判断

        if (cart == null) {
            //没有cart
             cart = new Cart();
            session.setAttribute("cart", cart);
            return cart;
        } else {
            //有
            return cart;
        }
    }



}
