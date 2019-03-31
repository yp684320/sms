package day10.Demon04;
//定义实现类
public class C implements A,B {
    //多个抽象方法时,实现类必须重写所有抽象方法,如果有重名,只需要重写一次
    @Override
    public void showA() {

    }

    @Override
    public void show() {

    }

    @Override
    public void shopwB() {

    }
}
