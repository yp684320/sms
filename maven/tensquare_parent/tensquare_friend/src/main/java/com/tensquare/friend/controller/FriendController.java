package com.tensquare.friend.controller;

import com.tensquare.friend.service.FriendService;
import com.tensquare.friend.service.NoFriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("friend")
@CrossOrigin
public class FriendController {

    @Autowired
    private FriendService friendService;
    @Autowired
    private NoFriendService noFriendService;

    //DELETE /friend/{friendid} 删除好友
    @RequestMapping(value = "{friendid}", method = RequestMethod.DELETE)
    public Result deleteFriend(@PathVariable String friendid,
                               HttpServletRequest request) {
        //使用jwt鉴权的方式,拿到自己的用户id
        Claims claims = (Claims) request.getAttribute("claims");

        //判断用户id是否获取不到,要求用户登录
        if (claims == null || "".equals(claims.getId())) {
            return new Result(false, StatusCode.LOGINERROR, "用户未登录");
        }

        String userId = claims.getId();
        friendService.deleteFriend(userId, friendid);

        return new Result(true, StatusCode.OK, "删除好友成功");
    }

    //PUT /friend/like/{friendid}/{type} 添加好友或非好友
    @RequestMapping(value = "like/{friendid}/{type}", method = RequestMethod.PUT)
    public Result like(@PathVariable String friendid,
                       @PathVariable String type,
                       HttpServletRequest request) {
        //使用jwt鉴权的方式,拿到自己的用户id
        Claims claims = (Claims) request.getAttribute("claims");

        //判断用户id是否获取不到,要求用户登录
        if (claims == null || "".equals(claims.getId())) {
            return new Result(false, StatusCode.LOGINERROR, "用户未登录");
        }

        //获取用户id
        String userId = claims.getId();

        //判断类型 1:喜欢 2：不喜欢
        if ("1".equals(type)) {
            //如果类型为1就是加好友
            Boolean bool = friendService.like(userId, friendid);

            if (bool == false) {
                return new Result(false, StatusCode.REPERROR, "不能重复添加好友");
            }

        } else {
            //如果类型不为1就是加非好友
            Boolean bool = noFriendService.add(userId, friendid);
            if (bool == false) {
                return new Result(false, StatusCode.REPERROR, "不能重复添加非好友");
            }
        }

        return new Result(true, StatusCode.OK, "操作成功");

    }
}
