package leetcode.problems.DynamicProgramming;

public class KadanesAlgorithmMaxSumSubarray {

    public static void main(String[] s){
        int[] a = {-4,-3,-2,-5,-6,-10};

        System.out.println(maxSum(a));
    }
    // works only when there is atleast one +ve integer in the array.
    private static int maxSum(int[] a){
        int maxSum = Integer.MIN_VALUE;
        int sumSoFar = 0;

        for(int i =0;i<a.length;i++){
            sumSoFar += a[i];
            // sum has become -ve by adding the current pos val; then the current val has minimised it.
            if(sumSoFar < 0){
                sumSoFar = 0;
            }
            maxSum = Math.max(maxSum,sumSoFar);
        }
        return maxSum;
    }

    private static int maxSumEvenWithAllNegInts(int[] a){
        if(a.length ==0){
            return Integer.MIN_VALUE;
        }

        int max = a[0];
        for(int i =1;i<a.length;i++){
            if(a[i-1]>0){
                a[i]+=a[i-1];
            }
            max = Math.max(a[i],max);
        }
        return max;
    }
}
