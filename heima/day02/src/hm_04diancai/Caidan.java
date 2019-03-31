package hm_04diancai;
//菜单类
public class Caidan {
    //成员变量
    private String name;
    private String id;
    private int price;
    //构造方法
    public Caidan() {
    }
    public Caidan(String name, String id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  name + '\t'  + id + '\t' + price ;
    }

}
