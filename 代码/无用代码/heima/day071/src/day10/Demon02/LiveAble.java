package day10.Demon02;
//定义接口
public interface LiveAble {
    //默认方法
    public default void fly(){
        System.out.println("飞上天");
    }
}
