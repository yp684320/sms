package cn.itcast.core.controller.cart;

import cn.itcast.core.entity.Result;
import cn.itcast.core.pojo.cart.Cart;
import cn.itcast.core.pojo.item.Item;
import cn.itcast.core.pojo.order.OrderItem;
import cn.itcast.core.service.cart.CartService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Reference
    private CartService cartService;
    /**
     * 将商品加入购物车中
     * @param itemId
     * @param num
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/addGoodsToCartList.do")
    //服务端支持CORS
    // response.setHeader("Access-Control-Allow-Origin","http://localhost:9003");
    //携带cookie
    // response.setHeader("Access-Control-Allow-Credentials","true");
    //将商品添加到购物车
    @CrossOrigin(origins = "http://localhost:9003")
    public Result addGoodsToCartList(Long itemId , Integer num , HttpServletRequest request, HttpServletResponse response){
        try{
           String username = SecurityContextHolder.getContext().getAuthentication().getName();
            //System.out.println(username);
            // 将商品添加到购物车  未登录情况下
            // 1, 定义一个空的存放购物车的集合对象
            List<Cart> cartList = null;
            // 定义一个开关
            boolean flag = false;
            // 2, 判断本地是否有购物车  有 取出来赋值给定义好的空车集合
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0 ) {
                for (Cookie cookie : cookies) {
                    if ("BUYER_CART".equals(cookie.getName())) {
                        String value = cookie.getValue();
                       //cartList = JSON.parseArray(value, Cart.class);
                        cartList = JSON.parseArray(URLDecoder.decode(value,"utf-8"),Cart.class);
                         //找到即可跳出循环
                        flag = true;
                        break;
                    }
                }
            }
            // 3, 没有 说明是第一次 需要创建一个空车集合对象
            if (cartList == null) {
                cartList = new ArrayList<>();
            }
            // 4, 有车了  将商品装车
            Cart cart = new Cart();
            Item item = cartService.findOne(itemId);
            cart.setSellerId(item.getSellerId());//存储商家id
            List<OrderItem> orderItemList = new ArrayList<>();
            OrderItem orderItem = new OrderItem();
            orderItem.setItemId(itemId);//库存id
            orderItem.setNum(num);      //购买数量
            orderItemList.add(orderItem);
            cart.setOrderItemList(orderItemList);
            // 4.1 判断该商品是否属于同一个商家
            int sellerIndexOf = cartList.indexOf(cart);  //判断商品是否属于同一个商家
            // 4.1.1 是同一个商家
            if (sellerIndexOf != -1) {
                //判断是否属于同款商品
                Cart oldCart = cartList.get(sellerIndexOf);
                List<OrderItem> oldOrderItemList = oldCart.getOrderItemList();
                int itemIndexOf = oldOrderItemList.indexOf(orderItem);
                //判断是否是同款商品
                // A 判断该商品是否存在
                if (itemIndexOf != -1){
                    //同款商品 合并购买数量
                    OrderItem oldOrderItem = oldOrderItemList.get(itemIndexOf);
                    oldOrderItem.setNum(oldOrderItem.getNum() + num);
                }else{
                    // 同商家但不同款商品
                    oldOrderItemList.add(orderItem);
                }

            }else{
                //不是同一个商家
                cartList.add(cart);

            }
            // 判断用户是否登录  已登录 保存到服务器端(redis)  未登录 保存到客户端
            if (!"anonymousUser".equals(username)) {
                // 已登录 保存到服务器端(redis)
                cartService.saveCartToRedis(username,cartList);
                // 清空本地的购物车
                Cookie cookie = new Cookie("BUYER_CART", null);
                //Cookie cookie = new Cookie("BYUER_CART",JSON.toJSONString(cartList));
                cookie.setPath("/"); //cookie共享
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }else{
                String s = JSON.toJSONString(cartList);
                // 5 将商品保存到该计算机本地
                Cookie cookie = new Cookie("BUYER_CART", URLEncoder.encode(s,"utf-8"));
                //Cookie cookie = new Cookie("BYUER_CART",JSON.toJSONString(cartList));
                cookie.setPath("/"); //cookie共享
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
            }

            return new Result(true,"商品成功加入购物车");
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false,"加入购物车失败");
        }
    }
    /**
     * 回显购物车中的列表数据
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/findCartList.do")
    public List<Cart> findCartList(HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException {
        // 未登录：从cookie中获取
        List<Cart> cartList = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if("BUYER_CART".equals(cookie.getName())){
                    String text = cookie.getValue(); // 购物车的json串
                   // JSON.parseArray(text,Cart.class);
                  cartList = JSON.parseArray(URLDecoder.decode(text,"utf-8"), Cart.class);
                    break;
                }
            }
        }
        //  已登录：从redis中获取
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!"anonymousUser".equals(username)) {
            // 已登录 保存到服务器端(redis)
            cartService.saveCartToRedis(username,cartList);
            // 清空本地的购物车
            Cookie cookie = new Cookie("BUYER_CART",null);
            //Cookie cookie = new Cookie("BYUER_CART",JSON.toJSONString(cartList));
            cookie.setPath("/"); //cookie共享
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            // 从redis中获取
           cartList = cartService.findCartListFromRedis(username);
        }


        // 对购物车中的数据进行填充
        if(cartList != null && cartList.size() > 0){
            cartList = cartService.autoDataToCart(cartList);
        }
        return cartList;
    }
}

