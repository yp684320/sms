package hm01_lambda;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("bbbb");
        list.add("aaaaaa");
        list.add("ccc");
        list.add("dd");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        /*Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length()-s2.length();
            }
        });*/
        Collections.sort(list,
            (String s1, String s2)-> {
                return s1.length()-s2.length();
            }
       );
        System.out.println(list);
    }
}
