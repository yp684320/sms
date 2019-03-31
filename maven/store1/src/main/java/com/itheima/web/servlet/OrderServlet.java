package com.itheima.web.servlet;

import com.itheima.constants.Global;
import com.itheima.domain.*;
import com.itheima.service.OrderService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.MyBeanUtil;
import com.itheima.utils.PaymentUtil;
import com.itheima.utils.UUIDUtil;
import com.itheima.web.vo.ResultVo;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static junit.framework.TestCase.fail;

@WebServlet("/order")
public class OrderServlet extends BaseServlet {
    private OrderService orderService= BeanFactory.newInstance(OrderService.class);
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //接受请求
        //第一个保证 必须有人处于登录状态
        //从session中获取用户
        User user = (User) request.getSession().getAttribute("user");
        if (user==null) {
            noLogin();
            return;
        }
        //第二个保证 购物车得有数据
       //获取购物车
        Cart cart = getCart(request);
        //判断购物车是否有东西
        if (cart.getItems().size() <= 0) {
            fail("购物车里没有商品");
        } else {
            //将session中存储的购物车信息 取出来
            Order order = new Order();
            //将购物车中的信息保存在order中
            // 购物车----->order
            //cart----->order
            String oid = UUIDUtil.getId();
            order.setOid(oid);
            order.setTotal(cart.getTotal());
            order.setOrdertime(new Date());
            order.setState(Global.ORDER_STATE_WEIFUKUAN);
            order.setUid(user.getUid());
            //购物项----->orderItem
            //cartItem---->OrderItem
            Collection<CartItem> items = cart.getItems();
            ArrayList<OrderItem> orderItems = new ArrayList<>();
            for (CartItem item : items) {
                //转换订单项
                OrderItem orderItem = new OrderItem();
                orderItem.setCount(item.getCount());
                orderItem.setSubTotal(item.getSubtotal());
                orderItem.setOid(oid);
                orderItem.setPid(item.getProduct().getPid());
                orderItems.add(orderItem);
            }
            //调用service 保存
            orderService.save(order,orderItems);
            //返回结果
            success(oid);
        }
    }
    protected void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询订单的信息
        String oid = request.getParameter("oid");

        //调用service 根据 oid查询订单
        Order order=orderService.findOrderWithItems(oid);
        //返回

        ResultVo vo = new ResultVo(ResultVo.CODE_SUCCESS, "");

        vo.setData(order);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            @Override
            public Object processArrayValue(Object o, JsonConfig jsonConfig) {
                return null;
            }

            @Override
            public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = dateFormat.format(o);
                return format;
            }
        });


        String s = JSONObject.fromObject(vo,jsonConfig).toString();
        response.getWriter().print(s);
        // success(order);

    }
    protected void findMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询某个人订单
        //必须保证有人登录
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            noLogin();
            return;
        }
        //获取uid
        String uid=user.getUid();

        //获取参数PageNumber
        int pageNumber=1;
        String pageNumber_str = request.getParameter("pageNumber");
        if(pageNumber_str!=null){
            pageNumber=Integer.parseInt(pageNumber_str);
        }

        //设置pageSize
        int pageSize=3;

        //查询
        PageBean<Order> pb= orderService.findMyOrders(uid,pageNumber,pageSize);



        //返回
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            @Override
            public Object processArrayValue(Object o, JsonConfig jsonConfig) {
                return null;
            }

            @Override
            public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = dateFormat.format(o);
                return format;
            }
        });


        success(pb,jsonConfig);


    }

    protected void topay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        Map<String, String[]> parameterMap = request.getParameterMap();

        //封装对象
        Order order = new Order();

        MyBeanUtil.populate(order,parameterMap);


        //更新数据库信息
        orderService.updateShouhuoren(order);


        //拼接跳转地址
        // 组织发送支付公司需要哪些数据
        String pd_FrpId = request.getParameter("pd_FrpId");
        String p0_Cmd = "Buy";
        String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
        String p2_Order = order.getOid();
        String p3_Amt = "0.01";////真实开发order.getTotal()

        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        // 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
        // 第三方支付可以访问网址
        String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("responseURL");
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        // 加密hmac 需要密钥
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
                p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
                pd_FrpId, pr_NeedResponse, keyValue);


        //发送给第三方
        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);
       //返回地址
        success(sb.toString());

    }

    protected void callback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检验数据的合法性
        //验证数据的合法性
        String p1_MerId = request.getParameter("p1_MerId");
        String r0_Cmd = request.getParameter("r0_Cmd");
        String r1_Code = request.getParameter("r1_Code");
        String r2_TrxId = request.getParameter("r2_TrxId");
        String r3_Amt = request.getParameter("r3_Amt");
        String r4_Cur = request.getParameter("r4_Cur");
        String r5_Pid = request.getParameter("r5_Pid");
        String r6_Order = request.getParameter("r6_Order");
        String r7_Uid = request.getParameter("r7_Uid");
        String r8_MP = request.getParameter("r8_MP");
        String r9_BType = request.getParameter("r9_BType");
        String rb_BankId = request.getParameter("rb_BankId");
        String ro_BankOrderId = request.getParameter("ro_BankOrderId");
        String rp_PayDate = request.getParameter("rp_PayDate");
        String rq_CardNo = request.getParameter("rq_CardNo");
        String ru_Trxtime = request.getParameter("ru_Trxtime");
        // 身份校验 --- 判断是不是支付公司通知你
        String hmac = request.getParameter("hmac");
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
                "keyValue");

        // 自己对上面数据进行加密 --- 比较支付公司发过来hamc
        boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
                r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
                r8_MP, r9_BType, keyValue);



        if(isValid){

            //通知 某个订单支付成功了

            //将订单状态该为已付款

            if(r9_BType.equals("1")){
                //修改订单状态

                orderService.updateState(r6_Order,Global.ORDER_STATE_YIFUKUAN);

                //给用户浏览器返回信息
                String msg="您的订单号为:"+r6_Order+",金额为:"+r3_Amt+"已经支付成功,等待发货~~";
                request.setAttribute("msg",msg);
                request.setAttribute("oid",r6_Order);

                request.getRequestDispatcher("/success.jsp").forward(request,response);
            }else{
                //第三方服务器发送的请求   跟用户的浏览器没关系

                //修改订单状态
                orderService.updateState(r6_Order,Global.ORDER_STATE_YIFUKUAN);


                //记得回写一个 success的字符串
                response.getWriter().print("success");


            }
        }else{
            //别逗了
            response.getWriter().print("非法请求!!!");
        }
    }

    protected void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+":"+password);

        success();

    }
public Cart getCart(HttpServletRequest request){
        //保证art对象   一次会话只有一个
    //从session中获取
    HttpSession session = request.getSession();
    Cart cart = (Cart) session.getAttribute("cart");
    //判断
    if (cart == null) {
        //session中没有
        cart = new Cart();
        session.setAttribute("cart",cart);
        return cart;
    } else {
        //有
        return cart;
    }

}

}
