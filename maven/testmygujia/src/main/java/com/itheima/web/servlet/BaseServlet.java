package com.itheima.web.servlet;

import com.itheima.utils.ResponseUtil;
import com.itheima.web.vo.ResultVo;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //获取你想调用我的哪个逻辑
        String md = request.getParameter("md");

        /*if("findAll".equals(md)){
            FindAll(request,response);
        }else if("findByPage".equals(md)){
            findByPage(request,response);
        }else if("del".equals(md)){
            del(request,response);
        }*/

        //规律 就是md就是我们想要方法而已  执行方法

        //反射获取你的想要的方法 并且执行
        //方法 getDeclaredMethod 获取当前类的方法 不包含从父类继承的
        //方法 传参
        //第一个参数 方法名
        //第二个参数 形参列表

        try {
            Method method = this.getClass().getDeclaredMethod(md, HttpServletRequest.class, HttpServletResponse.class);
            //invoke 就是让该方法执行的意思
            //参数1 调用者
            //参数2 实参列表


            method.invoke(this,request,response);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fail(Object data) throws IOException {
        ResultVo vo = new ResultVo(ResultVo.CODE_FAILED, data, "");
        ResponseUtil.get().getWriter().print(JSONObject.fromObject(vo).toString());
    }

    public void success() throws IOException {
        ResultVo vo = ResultVo.success();

        ResponseUtil.get().getWriter().print(JSONObject.fromObject(vo).toString());
    }
    public void success(Object data) throws IOException {
        ResultVo vo = ResultVo.success();
        vo.setData(data);
        ResponseUtil.get().getWriter().print(JSONObject.fromObject(vo).toString());
    }
    public void noLogin() throws IOException {
        ResultVo vo = new ResultVo(ResultVo.CODE_NOLOGIN,"非状态登录状态");
        ResponseUtil.get().getWriter().print(JSONObject.fromObject(vo).toString());
    }
}
