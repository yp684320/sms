package 升级考试卷一;

public interface RedRay {
    public abstract void controlTV(TV tv);
    public  default void connecting(){
        System.out.println("外接设备,连接成功,可以使用红外线");
    }
}
