package hm01_daima;
/*pid INT PRIMARY KEY AUTO_INCREMENT,
	pname VARCHAR(20),
	price DOUBLE,
	category_id VARCHAR(32)*/
public class Product {
    private int pid;
    private String pname;
    private String price;
    private String category_id;

    public Product() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price='" + price + '\'' +
                ", category_id='" + category_id + '\'' +
                '}';
    }
}
