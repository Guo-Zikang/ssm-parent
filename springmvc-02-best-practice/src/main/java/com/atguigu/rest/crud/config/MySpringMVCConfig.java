package com.atguigu.rest.crud.config;

import com.atguigu.rest.crud.interceptor.MyHandlerInterceptor0;
import com.atguigu.rest.crud.interceptor.MyHandlerInterceptor1;
import com.atguigu.rest.crud.interceptor.MyHandlerInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    MyHandlerInterceptor0 myHandlerInterceptor0;

    @Autowired
    MyHandlerInterceptor1 myHandlerInterceptor1;

    @Autowired
    MyHandlerInterceptor2 myHandlerInterceptor2;

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor0)
                .addPathPatterns("/**"); // 拦截所有请求
        registry.addInterceptor(myHandlerInterceptor1)
                .addPathPatterns("/**");
        registry.addInterceptor(myHandlerInterceptor2)
                .addPathPatterns("/**");
    }
}
