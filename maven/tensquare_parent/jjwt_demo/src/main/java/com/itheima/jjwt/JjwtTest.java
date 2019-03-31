package com.itheima.jjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

public class JjwtTest {

    //创建jwt
    @Test
    public void test1() {
        //获取当前时间
        long now = System.currentTimeMillis();
        //当前时间设置过期时间
        Date exp = new Date(now + (60 * 1000));


        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("123")
                .setIssuedAt(new Date())
                .setSubject("张三")
                //第一个参数是签名的算法,第二个参数是加盐
                .signWith(SignatureAlgorithm.HS256, "itheima")
                //自定义载荷数据
                .claim("roles", "管理员")
                .claim("职位", "CEO")
                //设置token的过期时间,建议要设置
                .setExpiration(exp);

        System.out.println(jwtBuilder.compact());
    }

    //jwt解析
    @Test
    public void test2() {
        //String token = "eyJhbGciOiJIUzI1NiJ9" +
        //        ".eyJqdGkiOiIxMjMiLCJpYXQiOjE1NTI1NTQ4MzcsInN1YiI6IuW8oOS4iSJ9" +
        //        ".GPRIHQmBGuXxHWOFnE3YXCFY5WWGHnPLLWfbWSI8cPQ";
        //String token = "eyJhbGciOiJIUzI1NiJ9" +
        //        ".eyJqdGkiOiIxMjMiLCJpYXQiOjE1NTI1NTU1NzQsInN1YiI6IuW8oOS4iSIsInJvbGVzIjoi566h55CG5ZGYIiwi6IGM5L2NIjoiQ0VPIn0" +
        //        ".hGzqXyex995bVeaWZHIBC640N_hyYfXxGBo-H6S38wY";

        String token = "eyJhbGciOiJIUzI1NiJ9" +
                ".eyJqdGkiOiIxMjMiLCJpYXQiOjE1NTI1NTU4MzQsInN1YiI6IuW8oOS4iSIsInJvbGVzIjoi566h55CG5ZGYIiwi6IGM5L2NIjoiQ0VPIiwiZXhwIjoxNTUyNTU1ODk0fQ" +
                ".Uuiltq6Bk3u8KtPHQ2qu3RGguvQBl9dnw5k_wsdHxRQ";

        Claims claims = Jwts.parser().setSigningKey("itheima").parseClaimsJws(token).getBody();

        System.out.println("id:" + claims.getId());
        System.out.println("用户名:" + claims.getSubject());
        System.out.println("时间:" + claims.getIssuedAt());
        System.out.println("roles:" + claims.get("roles").toString());
        System.out.println("职位:" + claims.get("职位").toString());
    }


}
