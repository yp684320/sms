package com.tensquare.friend.config;

import com.tensquare.friend.intercept.JwtIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtIntercept jwtIntercept;


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtIntercept)
                .addPathPatterns("/**")//所有的请求都被拦截
                .excludePathPatterns("/**/login");//登录请求不被拦截
    }
}
