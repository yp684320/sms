package com.itheima.web.servlet;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;
import com.itheima.web.vo.ResultVo;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/product")
public class ProductServlet extends BaseServlet {
    private ProductService productService = BeanFactory.newInstance(ProductService.class);
    protected void hotsAndNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //接受请求
		//调用service 查询数据
       //查询最热商品
       List<Product> hots =  productService.findHots();
       //查询最新商品
        List<Product> news = productService.findNews();
       // System.out.println(1);
        Map<String, List> map = new HashMap<>();
        map.put("hots",hots);
        map.put("news",news);
        //新建一个ResultVo
        //System.out.println(2);
        ResultVo vo = new ResultVo(ResultVo.CODE_SUCCESS,"");
        vo.setData(map);
        //Json转换
        JsonConfig jc = new JsonConfig();
        jc.setExcludes(new String[]{"cid", "is_hot", "market_price", "pdate", "pdesc", "pflag"});

        String s = JSONObject.fromObject(vo, jc).toString();
        response.getWriter().print(s);


    }
    protected void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受请求  获取参数
        String pid = request.getParameter("pid");
        //调用service 根据pid查询那个商品
      Product product = productService.findOne(pid);
        ResultVo vo = new ResultVo(ResultVo.CODE_SUCCESS);
        vo.setData(product);
        JsonConfig jsonConfig = new JsonConfig();
        //用来向json声明序列化时  不需要序列化的字段
        jsonConfig.setExcludes(new String[]{"is_hot","pflag","cid","pdate"});
        String s = JSONObject.fromObject(vo,jsonConfig).toString();
        //返回数据
        response.getWriter().print(s);

    }


    protected void findByPageWithCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String cid = request.getParameter("cid");
        String pageNumberStr = request.getParameter("pageNumber");

        //判断是否传pagenumber
        if (pageNumberStr==null) {
            pageNumberStr="1";

        }
        int pageNumber = Integer.parseInt(pageNumberStr);
        int pageSize = 12;
        //调用service  查询数据
        PageBean<Product> products = productService.findByPageWithCid4PB(cid ,pageNumber,pageSize);
        //把不需要的数据 序列化掉
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"cid", "is_hot", "market_price", "pdate", "pdesc", "pflag"});
        //返回数据
        /*ResultVo vo = new ResultVo(ResultVo.CODE_SUCCESS,"");
        vo.setData(products);
        String s = JSONObject.fromObject(vo).toString();
        response.getWriter().print(s);*/
        success(products,jsonConfig);
    }
}
