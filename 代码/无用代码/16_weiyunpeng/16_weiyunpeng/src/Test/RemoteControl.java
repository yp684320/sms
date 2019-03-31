package Test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class RemoteControl {

    public void controlTV(TV tv) {
        System.out.println("遥控器控制电视");
        System.out.println("请输入一个电视节目");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //tv.play();
    }

}