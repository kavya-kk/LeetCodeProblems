package leetcode.problems.General;

public class ReverseInteger {
    public static void main(String[] str){
        int x = Integer.MIN_VALUE;
        System.out.println(x);
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        // if single digit number
        if(x >-10 && x<10){
            return x;
        }
        int negate = x<0 ? -1: 1;
        x = Math.abs(x);
        int resultNum = 0;
        int prev;
        while(x>0){
            prev = resultNum;
            resultNum = resultNum*10 + x%10;
            if(resultNum/10 != prev){
                return 0;
            }
            x = x/10;
        }

        return resultNum*negate;
    }
}
