package day11.Test2;
/*定义学生类：

- 属性：姓名，出勤。
- 提供基本的构造方法和get方法，set方法。
*/
 class Student {
     //
    private String name;
    private boolean come;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, boolean come) {
        this.name = name;
        this.come = come;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCome() {
        return come;
    }

    public void setCome(boolean come) {
        this.come = come;
    }
}
