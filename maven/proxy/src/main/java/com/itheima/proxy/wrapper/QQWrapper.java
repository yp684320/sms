package com.itheima.proxy.wrapper;

public class QQWrapper implements Car {

    private Car qq;

    public QQWrapper(Car qq) {
        super();
        this.qq = qq;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        qq.run();
        long end = System.currentTimeMillis();
        System.out.println("百公里加速用时"+(end-start));


    }

    @Override
    public void stop() {

    }

    @Override
    public int oilTank() {
        return 0;
    }

    @Override
    public void driver(String driverName) {

    }

    @Override
    public Car didi() {
        return null;
    }
}
