package leetcode.problems.General;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoInts {

    public static void main(String[] str) {
        //System.out.println(Integer.MAX_VALUE);
        System.out.println(divide(Integer.MIN_VALUE,-3));

    }

    public static int divide(int dividend, int divisor){
        int quotient = 0;
        //dividend is -inf
        if(dividend == Integer.MIN_VALUE){
            // if divisor is -1,
            if(divisor == -1){
                return Integer.MAX_VALUE;
            }
            // if divisor is 1
            else if (divisor == 1){
                return Integer.MIN_VALUE;
            }
            // if divsor is -inf
            else if (divisor == Integer.MIN_VALUE){
                return 1;
            }
            // if divisor is none among -1, 1, -inf, then to avoid overflows, reduce the dividend so that in the below operations it doesnt overflow
            dividend+=Math.abs(divisor);
            quotient++;
        }
        if(divisor == Integer.MIN_VALUE){
            return 0;
        }
        int sign = (dividend <0) ^ (divisor <0) ? -1:1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while(dividend >= divisor){
            int temp = divisor;
            int times = 1;
            while(dividend - temp > temp){
                temp <<= 1;
                times <<=1;
            }
            dividend -=temp;
            quotient +=times;
        }

        return quotient*sign;
    }
    public static int divideWithLong(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        // if both divisor and dividend are -ve or if both are +ve then sign is +ve, so xor can be used.
        int sign = (divisor <0) ^ (dividend<0) ? -1: 1;

        //convert them to long to handle the over flows.
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        int result = 0;
        while(ldividend >= ldivisor){
            long temp = ldivisor;
            int times = 1;
            while(ldividend >= temp<<1){
                temp <<= 1;
                times <<= 1;
            }
            ldividend -=temp;
            result+= times;
        }
        return result * sign;
    }
}
