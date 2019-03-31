package day10.Demon05;
//定义父类
public class House {
    //成员变量
    private String size;
//构造方法
    public House(String size) {
        this.size = size;
    }

    public House() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
