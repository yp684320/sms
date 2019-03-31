package day10.Test01;

public class SmartAudi extends Audi implements Smart {
    @Override
    public void automaticParkig() {
        System.out.println("智能奥迪车在自动泊车");

    }
    @Override
    public void automaticDrive() {
        System.out.println("智能艾迪车在无人驾驶");

    }
}
