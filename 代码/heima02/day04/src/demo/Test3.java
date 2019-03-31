package demo;

public class Test3 {
    public static void main(String[] args) {

        System.out.println(mul(20));
    }
    public static double mul(double n){
        if (n == 1) {
            return 1;
        } else {
            return n * mul(n - 1);
        }

    }
//public static void main(String[] args){
//    System.out.println(Mul(20));
// }
//    public static double Mul(double n){
//    if(n == 1)
//        return 1;
//    else
//        return n*Mul(n-1);
//}

}
