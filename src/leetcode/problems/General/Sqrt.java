package leetcode.problems.General;
//https://leetcode.com/problems/sqrtx
public class Sqrt {

    public static void main(String[] str){
        int num = 6;
        System.out.println(sqrtBinarySearch(num));
    }

    // calculator solution with Exponent function. and using Math functions in java.
    private static int sqrt(int num){
        // x ^ (1/2) = e ^ ( (1/2) * log (x));
        int result =(int) Math.pow(Math.E, 0.5 * Math.log(num));

        if((result+1) * (result+1) > num){
            return result;
        }
        return result+1;
    }

    // using binary search.
    // intuition:  we know that the sqrt of any number will be less than number/2. so doing a binary search on the list of numbers
    private static int sqrtBinarySearch(int num){
        // num <2 return the number since the sqrt will be
        if( num <2) {
            return num;
        }
        int left = 2;
        int right = num/2;
        int mid = 0;
        while(left <= right){
            mid = left + (right-left)/2;

            // it is important to use long since the product may exceed the integer limit and the result will be unexpected if int is used.
            long prod = (long)mid*mid;
            if(prod > num){
                right = mid-1;
            }else if (prod <num){
                left = mid+1;
            }else {
                return mid;
            }
        }

        return right;
    }


}
