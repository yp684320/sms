package com.tensquare.qa.config;

import io.jsonwebtoken.Claims;

public class JwtThreadLocal {

    private static ThreadLocal<Claims> threadLocal = new ThreadLocal<>();

    public static void setClaims(Claims claims) {
        threadLocal.set(claims);
    }

    public static Claims getClaims() {
        return threadLocal.get();
    }

}
