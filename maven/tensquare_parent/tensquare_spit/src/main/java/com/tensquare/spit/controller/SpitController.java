package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    // PUT /spit/thumbup/{spitId} 吐槽点赞
    @RequestMapping(value = "thumbup/{spitId}", method = RequestMethod.PUT)
    public Result thumbup(@PathVariable String spitId) {
        //需要控制点赞,一个用户不能重复点赞
        //因为数据价值较低,数据量较小,读写频率较高,使用redis合适
        //用户点赞之后,保存用户id和吐槽id的关系(根据redis的key是唯一的,把key设置为userid和spitid的拼接字符串)
        //用户点赞之前,先查询用户有没有点赞过

        //现在没有做用户登录的操作,假装已经拿到了
        String userId = "123";


        //判断用户是否已经点过赞
        if (redisTemplate.opsForValue().get("thumbup_" + userId + "_" + spitId) != null) {
            //如果点过赞,提示不能重复点赞
            return new Result(false, StatusCode.REPERROR, "已点过赞,不能重复点赞");
        } else {
            //如果没有点过赞,用户可以点赞,提示点赞成功
            spitService.thumbup(spitId);

            //点赞成功,要把用户id和被点赞的吐槽id建立关系,就是保存到redis中
            redisTemplate.opsForValue().set("thumbup_" + userId + "_" + spitId, "1");
            return new Result(true, StatusCode.OK, "点赞成功");
        }
    }

    //    GET /spit/comment/{parentid}/{page}/{size} 根据上级ID查询吐槽数据（分页）
    @RequestMapping(value = "comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
    public Result comment(@PathVariable String parentid,
                          @PathVariable Integer page,
                          @PathVariable Integer size) {
        Page<Spit> pageData = spitService.comment(parentid, page, size);

        //封装分页的结果对象
        PageResult<Spit> pageResult = new PageResult<>(
                pageData.getTotalElements(), pageData.getContent()
        );

        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    //    GET /spit/{spitId} 根据ID查询吐槽
    @RequestMapping(value = "{spitId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String spitId) {
        Spit spit = spitService.findById(spitId);
        return new Result(true, StatusCode.OK, "查询成功", spit);
    }

    //    GET /spit Spit全部列表
    @RequestMapping(method = RequestMethod.GET)
    public Result findById() {
        List<Spit> list = spitService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    //    POST /spit 增加吐槽,发布吐槽
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Spit spit) {
        spitService.save(spit);
        return new Result(true, StatusCode.OK, "新增成功");
    }

    //    PUT /spit/{spitId} 修改吐槽
    @RequestMapping(value = "{spitId}", method = RequestMethod.PUT)
    public Result updateById(@PathVariable String spitId,
                             @RequestBody Spit spit) {
        //设置修改条件，吐槽的id
        spit.set_id(spitId);

        //执行修改
        spitService.updateById(spit);

        return new Result(true, StatusCode.OK, "修改成功");

    }

    //    DELETE /spit/{spitId} 根据ID删除吐槽
    @RequestMapping(value = "{spitId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String spitId) {
        spitService.deleteById(spitId);
        return new Result(true, StatusCode.OK, "删除成功");
    }


}
