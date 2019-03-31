package day10.Demon05;
//定义KTV类
public class KTV extends House implements Call{
    //构造方法

    public KTV() {
    }

    public KTV(String size) {
        super(size);
    }

    @Override
    public void sing() {
        System.out.println(getSize()+"平米的房间里,唱着歌曲");

    }
}
