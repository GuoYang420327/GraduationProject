package com.gy.graduationproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器配置类
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).excludePathPatterns(//排除拦截的接口
                "/users/login", //登录接口
                "/users/register", //注册接口

                "/usersRecord/createUsersRecord",//添加用户记录接口
                "/usersRecord/findUsersRecordByUserId",//根据用户名查询用户记录接口

                "/knowledge/**",//所有知识点接口

                "/video/**",//所有视频接口

                "/questions/**",//所有问题接口

                "/usersQuestionsAccuracy/**"//所有用户问题正确率接口
        );
    }
}
