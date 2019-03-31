package com.tensquare.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    //PUT  /user/fanscount/{x}/{userid}  修改粉丝数
    @RequestMapping(value = "fanscount/{x}/{userid}", method = RequestMethod.PUT)
    public Result fanscount(@PathVariable Integer x,
                            @PathVariable String userid) {
        //修改粉丝数
        userService.fanscount(x, userid);

        return new Result(true, StatusCode.OK, "修改成功");
    }


    //PUT  /user/followcount/{x}/{userid}  修改关注数
    @RequestMapping(value = "followcount/{x}/{userid}", method = RequestMethod.PUT)
    public Result followcount(@PathVariable Integer x,
                            @PathVariable String userid) {
        //修改关注数
        userService.followcount(x, userid);

        return new Result(true, StatusCode.OK, "修改成功");
    }

    //POST /user/login 登陆
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        User result = userService.login(user);

        if (result == null) {
            //没有查到,登录失败
            return new Result(false, StatusCode.LOGINERROR, "登录失败");
        } else {
            //用户登录成功,签发token
            String token = jwtUtil.createJWT(result.getId(), result.getMobile(), "user");

            Map map = new HashMap();
            map.put("mobile", result.getMobile());
            map.put("token", token);

            return new Result(true, StatusCode.OK, "登录成功", map);
        }
    }

    //POST /user/register/{code} 注册用户
    @RequestMapping(value = "register/{code}", method = RequestMethod.POST)
    public Result register(@PathVariable String code,
                           @RequestBody User user) {
        //校验手机验证码
        //如果没有手机验证码,要求用户点击按钮获取验证码
        if (code == null || "".equals(code)) {
            return new Result(false, StatusCode.ERROR, "请获取手机验证码");
        }

        //如果手机验证码错误,要求用户重新输入正确的验证码
        String redisCode = (String) redisTemplate.opsForValue().get("mobile_" + user.getMobile());

        if (redisCode == null || "".equals(redisCode)) {
            return new Result(false, StatusCode.ERROR, "手机验证码超时,请重新获取");
        }


        if (!code.equals(redisCode)) {
            return new Result(false, StatusCode.ERROR, "手机验证码输入错误");
        }

        //如果手机验证码正确,执行用户注册
        userService.register(user);

        return new Result(true, StatusCode.OK, "注册成功");
    }

    //POST /user/sendsms/{mobile} 发送手机验证码
    @RequestMapping(value = "sendsms/{mobile}", method = RequestMethod.POST)
    public Result sendsms(@PathVariable String mobile) {
        //发送短信
        userService.sendsms(mobile);

        return new Result(true, StatusCode.OK, "短信发送成功");
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", userService.findById(id));
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<User> pageList = userService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<User>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusCode.OK, "查询成功", userService.findSearch(searchMap));
    }

    /**
     * 增加
     *
     * @param user
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        userService.add(user);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param user
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody User user, @PathVariable String id) {
        user.setId(id);
        userService.update(user);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id, HttpServletRequest request) {
        ////在进行删除之前,需要先判断用户是否是管理员权限
        ////使用jwt进行鉴权
        ////前后端约定：前端请求微服务时需要添加头信息Authorization, 内容为Bearer + 空格 + token
        ////1. 从请求头获取token,就是获取请求头中的Authorization值
        //String header = request.getHeader("Authorization");
        //
        ////2. 判断获取到的值是否为空
        //if (header == null || "".equals(header)) {
        //    // 如果为空表示用户未登录
        //    return new Result(false, StatusCode.LOGINERROR, "用户未登录");
        //}
        //
        ////3. 判断获取到的值是否合法,判断是否以Bearer + 空格开头
        //if (!header.startsWith("Bearer ")) {
        //    //如果不合法,表示用权限错误
        //    return new Result(false, StatusCode.ACCESSERROR, "用户权限错误");
        //}
        //
        ////4. 获取token的值,进行解析,使用jwtutil工具类进行解析
        //String token = header.substring(7);
        //
        //try {
        //    Claims claims = jwtUtil.parseJWT(token);
        //
        //    //5.判断解析的claims是否为空
        //    if (claims == null) {
        //        //如果为空,表示权限错误
        //        return new Result(false, StatusCode.ACCESSERROR, "用户权限错误");
        //    }

        //从request中获取claims
        Claims claims = (Claims) request.getAttribute("claims");

        //判断用户是否是admin角色
        if (!"admin".equals(claims.get("roles"))) {
            //如果不是admin,说明用户没有权限
            return new Result(false, StatusCode.ACCESSERROR, "用户不是管理员");
        }

        //如果是admin,就可以执行删除
        userService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //
        //return new Result(false, StatusCode.ACCESSERROR, "用户权限错误");
    }

}
