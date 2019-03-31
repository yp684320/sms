package com.itheima.proxy.wrapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy01 {
    public static void main(String[] args) {
        //还是想要增强原有对象
        QQ qq = new QQ();
        //动态代理
        Car zq = (Car) Proxy.newProxyInstance(
                qq.getClass().getClassLoader(),
                qq.getClass().getInterfaces(),
                new ZQHandle(qq)
        );
        //zq.run();
        //zq.stop();
       // zq.driver("小明");
        int i = zq.oilTank();
        System.out.println(i);
    }
    public static class ZQHandle implements InvocationHandler{
         private Car car;

        public ZQHandle(Car car) {
            this.car = car;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("run".equals(method.getName())) {
                long start = System.currentTimeMillis();
                method.invoke(car);
                long end = System.currentTimeMillis();
                System.out.println("百公里加速用时" + (end - start) + "毫秒");

            } else if ("driver".equals(method.getName())) {
                System.out.println(args[0]);
              method.invoke(car,"小红");
            } else if ("oilTank".equals(method.getName())) {
                //调用原有方法
                Object o = method.invoke(car);
                System.out.println("原来返回的是"+o);
                return (Integer)o+50;
            } else {
                //调用原来的逻辑
                method.invoke(car);
            }
            return null;
        }
    }

}
