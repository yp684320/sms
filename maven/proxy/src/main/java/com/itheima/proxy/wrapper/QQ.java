package com.itheima.proxy.wrapper;

public class QQ implements Car{
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println("qq完成百公里加速   ");
        } catch (InterruptedException e) {


        }

    }

    @Override
    public void stop() {
        System.out.println("qq车停了");
    }

    @Override
    public int oilTank() {
        return 100;
    }

    @Override
    public void driver(String driverName) {
        System.out.println(driverName+"正在驾驶qq车");
    }

    @Override
    public Car didi() {
        System.out.println("qq正在滴滴");
        return this;
    }
}
