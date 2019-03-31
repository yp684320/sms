package com.tensquare.qa.config;

import com.tensquare.qa.intercept.JwtIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvmConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtIntercept jwtIntercept;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtIntercept)
                .addPathPatterns("/**");
    }
}
