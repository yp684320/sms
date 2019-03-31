package day10.Demon05;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Hotel extends House{
   //构造方法
    public Hotel(String size) {
        super(size);
    }
    public Hotel() {
    }

//成员方法
    public  void sleep(){
        System.out.println(getSize()+"平米的房间里,好好的睡一觉");

    }


}
