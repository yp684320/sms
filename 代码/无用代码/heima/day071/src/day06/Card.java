package day06;

public class Card {
    //成员变量
    private String hs;
    private String ds;
    //成员方法
    public void showCard(){
        System.out.println(hs+ds);
    }

    public String getHs() {
        return hs;
    }

    public String getDs() {
        return ds;
    }
/*使用满参就不需要set
    public void setHs(String hs) {
        this.hs = hs;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }*/
    //构造方法

    public Card(String hs, String ds) {
        this.hs = hs;
        this.ds = ds;
    }
}
