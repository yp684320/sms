package Domain;

public class Student {
    private int id;
    private String sname;
    private String pwd;

    public Student() {
    }

    public Student(int id, String sname, String pwd) {
        this.id = id;
        this.sname = sname;
        this.pwd = pwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public String getSname() {
        return sname;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
