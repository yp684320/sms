package demo;

public class Test4 {

        public static void main(String args[]){
            String str = "awdcsapplemifrhnapplefsfjiaapplercr";
            String s="apple";
            int count=0;
            int index=str.indexOf(s);
            if (str.indexOf(s)!=-1) {
                count++;
            }
            int leng=index+s.length();
            str=str.substring(leng);
            while (str.indexOf(s)!=-1) {
                index=str.indexOf(s);
                leng=index+s.length();
                str=str.substring(leng);
                count++;
            }
            System.out.println(count);


        }

}
