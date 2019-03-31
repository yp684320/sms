package day09.Test3;

public class Test03 {
    public static void main(String[] args) {
        //创建Duck类
        Duck duck = new Duck("鸭子","感冒",2,"发烧");
        duck.showMsg();
        duck.showSympton();
    }
}

//定义抽象类Poultry
abstract class Poultry {
    //成员变量(私有)
    private String name;
    private String symptom;
    private int age;
    private String illness;
//构造方法
    public Poultry() {
    }

    public Poultry(String name, String symptom, int age, String illness) {
        this.name = name;
        this.symptom = symptom;
        this.age = age;
        this.illness = illness;
    }//成员方法
    //抽象方法
    public abstract void showSympton();
    //普通方法
    public void showMsg(){
        System.out.print("动物种类:"+name);
        System.out.println(",年龄:"+age+"岁");
        System.out.println("入院原因:"+illness);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}//定义普通子类鸭子类Duck
class Duck extends Poultry{
    public Duck() {
    }

    public Duck(String name, String symptom, int age, String illness) {
        super(name, symptom, age, illness);
    }
    @Override
    public  void showSympton(){
        System.out.println("症状为:"+getSymptom());
    };
}
