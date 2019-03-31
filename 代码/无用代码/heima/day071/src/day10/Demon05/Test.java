package day10.Demon05;

public class Test {
    public static void main(String[] args) {
        //创建意见100平的宾馆
        Hotel hotel = new Hotel("100");
        hotel.sleep();
        //创建一个50 平的KTV
        KTV ktv = new KTV("50");
        ktv.sing();
    }
}
