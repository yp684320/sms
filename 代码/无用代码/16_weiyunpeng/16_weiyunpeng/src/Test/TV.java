package Test;

public class TV {
    private String name;

    public TV() {
    }

    public TV(String name) {
        this.name = name;
    }
    public void play(String channel ){
        System.out.println(name+"电视正在播放"+channel+"节目");
    }

}
