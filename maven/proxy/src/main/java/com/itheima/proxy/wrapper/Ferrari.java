package com.itheima.proxy.wrapper;

public class Ferrari implements Car {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("法拉利完成百公里加速");
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void stop() {
        System.out.println("法拉利停了");

    }

    @Override
    public int oilTank() {
        return 50;
    }

    @Override
    public void driver(String driverName) {
        System.out.println(driverName+"正在驾驶法拉利");
    }

    @Override
    public Car didi() {
        System.out.println("法拉利滴滴");
        return this;
    }
}
