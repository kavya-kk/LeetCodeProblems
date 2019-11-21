package leetcode.problems;

public class KadanesAlgorithmMaxSumSubarray {

    public static void main(String[] s){
        int[] a = {-4,-3,-2,-5,-6,-10};

        System.out.println(maxSum(a));
    }

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
}
