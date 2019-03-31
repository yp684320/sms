package com.tensquare.qa.controller;

import com.tensquare.qa.client.LabelClient;
import com.tensquare.qa.config.JwtThreadLocal;
import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private LabelClient labelClient;

    //使用问答微服务,调用基础微服务,实现根据id查询标签的功能
    @RequestMapping(value = "label/{labelId}", method = RequestMethod.GET)
    public Result queryLabelById(@PathVariable String labelId) {
        return labelClient.queryById(labelId);
    }

    //GET /problem/waitlist/{label}/{page}/{size} 等待回答列表
    @RequestMapping(value = "waitlist/{label}/{page}/{size}", method = RequestMethod.GET)
    public Result waitlist(@PathVariable String label,
                           @PathVariable Integer page,
                           @PathVariable Integer size) {
        Page<Problem> pageData = problemService.waitlist(label, page, size);
        PageResult<Problem> pageResult = new PageResult<>(
                pageData.getTotalElements(), pageData.getContent()
        );
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    //GET /problem/hotlist/{label}/{page}/{size} 热门问答列表
    @RequestMapping(value = "hotlist/{label}/{page}/{size}", method = RequestMethod.GET)
    public Result hotlist(@PathVariable String label,
                          @PathVariable Integer page,
                          @PathVariable Integer size) {
        Page<Problem> pageData = problemService.hotlist(label, page, size);
        PageResult<Problem> pageResult = new PageResult<>(
                pageData.getTotalElements(), pageData.getContent()
        );
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    //GET /problem/newlist/{label}/{page}/{size} 最新问答列表
    @RequestMapping(value = "newlist/{label}/{page}/{size}", method = RequestMethod.GET)
    public Result newlist(@PathVariable String label,
                          @PathVariable Integer page,
                          @PathVariable Integer size) {
        Page<Problem> pageData = problemService.newlist(label, page, size);
        PageResult<Problem> pageResult = new PageResult<>(
                pageData.getTotalElements(), pageData.getContent()
        );
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }


    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", problemService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", problemService.findById(id));
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
        Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Problem>(pageList.getTotalElements(), pageList
                .getContent()));
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusCode.OK, "查询成功", problemService.findSearch(searchMap));
    }

    /**
     * 增加
     *
     * @param problem
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Problem problem) {

        //从request中获取claims
        //从ThreadLocal中获取
        Claims claims = JwtThreadLocal.getClaims();

        if (claims != null && "user".equals(claims.get("roles"))) {
            //进行用户权限的判断
            problemService.add(problem);
            return new Result(true, StatusCode.OK, "增加成功");
        } else {
            return new Result(false, StatusCode.ACCESSERROR, "没有权限");
        }
    }

    /**
     * 修改
     *
     * @param problem
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Problem problem, @PathVariable String id) {
        problem.setId(id);
        problemService.update(problem);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        problemService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
