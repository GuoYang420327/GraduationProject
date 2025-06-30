package com.gy.graduationproject.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

//登录拦截器
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");//获取请求头中的token

        //验证token
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            return true;//验证通过，放行
        } catch (Exception e) {
            response.setStatus(401);//设置响应状态码为401
            return false;//验证失败，拦截
        }
    }
}
