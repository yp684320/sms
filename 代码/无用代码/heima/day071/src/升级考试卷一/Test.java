package 升级考试卷一;

public class Test {
    public static void main(String[] args) {
        //创建TV对象
        TV tv = new TV("海尔 ");
        RemoteControl r = new RemoteControl();
        r.controlTV(tv);
        Phone p = new Phone();
        p.connecting();
        p.controlTV(tv);
    }

}
