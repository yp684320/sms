package day06;

public class Test4 {
    public static void main(String[] args) {
        int[] salary ={15000,3000};
        Manager m = new Manager("james","9527",salary);
        m.intro();
        m.showSalary();
        m.work();
        System.out.println("=======");
        Coder c = new Coder();
        c.setName("Kobe");
        c.setNumber("0025");
        c.setSalary(10000);
        c.showSalary();
        c.intro();
        c.work();
    }

}
