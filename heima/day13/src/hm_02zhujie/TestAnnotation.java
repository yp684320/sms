package hm_02zhujie;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestAnnotation {
    public static void main(String[] args) throws Exception {
        System.out.println("---------获取类上注解的数据----------");
        test01();
        System.out.println("---------获取成员方法上注解的数据----------");
        test02();
    }
    //获取BookStore类上使用的Book注解
    public static void test01(){
    //获取BookStore类对应的Class对象
        Class c = BookStore.class;
        //判断BookStore类是否使用了Book注解
        if (c.isAnnotationPresent(Book.class)) {
            //根据注解Class获取注解对象
            Book book =(Book)c.getAnnotation(Book.class);
            //输出Book注解属性值
            System.out.println("书名:"+book.value());
            System.out.println("价格:"+book.price());
            System.out.println("作者:"+ Arrays.toString(book.author()));
        }
    }
    //获取BookStore类成员方法buyBook使用Book注解数据
    public static void test02() throws Exception {
        //获取BookStore类对应的Class对象
        Class c = BookStore.class;
        Method m = c.getMethod("buyBook");
        if (m.isAnnotationPresent(Book.class)) {
            Book book = (Book) m.getAnnotation(Book.class);
            System.out.println("书名：" + book.value());
            System.out.println("价格：" + book.price());
            System.out.println("作者：" + Arrays.toString(book.author()));
        }
    }
}
