package demo;

public class ClimbStairs {
    public int climbStairs(int n){
        int i= 1;
       if(n <= 0)
           return 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }

    }

    public static void main(String[] args) {
        ClimbStairs stairs = new ClimbStairs();
        int i = stairs.climbStairs(4);
        System.out.println(i);


    }
}
