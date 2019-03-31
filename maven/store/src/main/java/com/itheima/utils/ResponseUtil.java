package com.itheima.utils;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
    private static ThreadLocal<HttpServletResponse> tl=new ThreadLocal();
    public static HttpServletResponse get(){
        return tl.get();
    }
    public static void set(HttpServletResponse response){
        tl.set(response);
    }


}
