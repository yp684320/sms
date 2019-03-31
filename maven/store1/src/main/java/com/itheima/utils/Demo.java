package com.itheima.utils;

public class Demo {
    public static void main(String[] args) {
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();


        objectThreadLocal.set("小明");

        Object o = objectThreadLocal.get();

        System.out.println(o);

    }
}
