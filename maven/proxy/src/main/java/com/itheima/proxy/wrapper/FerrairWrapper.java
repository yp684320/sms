package com.itheima.proxy.wrapper;

public class FerrairWrapper implements Car {
    private Car ferrair;

    public FerrairWrapper(Car ferrair) {
        this.ferrair = ferrair;
    }

    @Override
    public void run()  {

                      long start = System.currentTimeMillis();
                ferrair.run();
                long end = System.currentTimeMillis();
                System.out.println("法拉利加速用时"+(end-start)+"毫秒");


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
