package leetcode.problems;

public class PowerOf {
    public static void main(String[] s){
        double x = 2.000;
        int n = -2;
        System.out.println(myPow(x,n));
    }

    private static double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n < 0 ){
            n = -n;
            x= 1/x;
        }
        return n%2==0 ? myPow(x*x,n/2) : x*myPow(x*x,n/2);
    }
}
