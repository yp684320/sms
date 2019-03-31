package com.itheima;

public class Demo {
    public Object query(){
        return new Long(191);
    }

    public int count(){
        return ((Long)this.query()).intValue();
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.count();
    }
}
