package leetcode.problems.General;

public class PowerOf {
    public static void main(String[] s){
        double x = 2.000;
        int n = -2;
        System.out.println(myPow(x,n));
    }

    private static double myPow(double x, int n) {

        if(n<0){
            x= 1/x;
            n = -n;
        }

        return helper(x,n);
    }

    private static double helper(double x, int N){
        if(N==0){
            return 1.0;
        }

        double halfPow = helper(x, N/2);

        if(N%2 == 0){
            return halfPow * halfPow;
        }else {
            return x * halfPow * halfPow;
        }
    }
}
