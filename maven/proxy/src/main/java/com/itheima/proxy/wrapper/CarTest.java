package com.itheima.proxy.wrapper;

public class CarTest {
    public static void main(String[] args) {
        QQ qq = new QQ();
       // qq.run();
        QQWrapper qqWrapper = new QQWrapper(qq);
        qqWrapper.run();

    }
}
