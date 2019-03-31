package day10.Test01;

public class Test {
    public static void main(String[] args) {
        //创建Audi对象
        Audi a = new Audi();
        a.run();
        //创建SmartAudi对象
        SmartAudi sa = new SmartAudi();
        sa.automaticDrive();
        sa.automaticParkig();
        Audi aa = sa;
        aa.run();
        Smart s = sa;
        s.automaticDrive();
        s.automaticParkig();
    }
}
