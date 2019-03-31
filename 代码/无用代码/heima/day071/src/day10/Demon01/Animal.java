package day10.Demon01;

public class Animal implements LiveAble{
    @Override
    public void eat() {
        System.out.println("吃东西");

    }

    @Override
    public void sleep() {
        System.out.println("睡觉");

    }
}
