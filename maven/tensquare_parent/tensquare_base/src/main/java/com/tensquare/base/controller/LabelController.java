package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("label")
//跨域解决的注解@CrossOrigin
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;

    //POST /label/search/{page}/{size} 标签条件查询带分页
    @RequestMapping(value = "search/{page}/{size}", method = RequestMethod.POST)
    public Result search(@RequestBody Label label,
                         @PathVariable Integer page,
                         @PathVariable Integer size) {

        Page<Label> pageData = labelService.search(label, page, size);

        //封装分页对象结果
        PageResult<Label> pageResult = new PageResult<>(
                pageData.getTotalElements(), pageData.getContent()
        );

        return new Result(true, StatusCode.OK, "查询成功", pageResult);

    }

    //POST /label/search 标签条件查询
    @RequestMapping(value = "search", method = RequestMethod.POST)
    //使用标签对象接受查询条件,Map集合也可以接收
    public Result search(@RequestBody Label label) {
        List<Label> list = labelService.search(label);

        return new Result(true, StatusCode.OK, "查询成功", list);

    }


    //GET /label/{labelId} 根据ID查询
    @RequestMapping(value = "{labelId}", method = RequestMethod.GET)
    public Result queryById(@PathVariable String labelId) {
        //int a = 1 / 0;
        System.out.println("这是基础微服务2");
        Label label = labelService.queryById(labelId);
        return new Result(true, StatusCode.OK, "查询成功", label);
    }

    //GET /label 标签全部列表
    @RequestMapping(method = RequestMethod.GET)
    public Result queryAll() {
        List<Label> list = labelService.queryAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    //POST /label 增加标签
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    //PUT /label/{labelId} 修改标签
    @RequestMapping(value = "{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId,
                         @RequestBody Label label) {
        //设置要求该的id到label中
        label.setId(labelId);

        //执行修改
        labelService.updateById(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //DELETE /label/{labelId} 根据ID删除
    @RequestMapping(value = "{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId) {
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
