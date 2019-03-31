package 升级考试卷一;

public class TV {
    private String name;

    public TV() {
    }

    public TV(String name) {
        this.name = name;
    }
    public void play(String channel){
        System.out.println(name+"电视台正在播放"+channel+"节目");
    }
}
