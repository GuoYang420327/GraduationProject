package com.gy.graduationproject;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    //生成token
    @Test
    public void testGen() {
        Map<String,Object>claims=new HashMap<>();//声明一个map集合存放token的信息
        claims.put("userId","123");
        claims.put("userNickname","张三");

        String token=JWT.create()//创建一个token
                .withClaim("user",claims)//声明token的信息
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))//设置token的过期时间
                .sign(Algorithm.HMAC256("mima"));//设置token的签名算法和签名密钥

        System.out.println(token);
    }

    @Test
    public void testParse() {
        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7InVzZXJOaWNrbmFtZSI6IuW8oOS4iSIsInVzZXJJZCI6IjEyMyJ9LCJleHAiOjE3NDEyODIzMTF9" +
                ".fcIWL3rMjSCqL74clACcpjcaXfzDwABGB6hrYNgvsmI";
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("mima")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);//验证token
        Map<String, Claim >claims=decodedJWT.getClaims();//获取token中的信息
        System.out.println(claims.get("user"));
    }
}
