package leetcode.problems.Array;
//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
public class MinSwapsForIncreasingSequence {

    public static void main(String[] s){
        int[] A = {1,2,3,7};
        int[] B = {1,3,5,4};
        System.out.println(minSwaps(A,B));
    }

    private static int minSwaps (int[] A, int[] B){
        int n = A.length;
        if(n == 0){
            return 0;
        }
        int swapCost = 1;
        int naturalCost = 0;
        for(int i =1;i<n;i++){
            // same array condition failed. do the opp of what was done in the prev step
            if(A[i-1]>=A[i] || B[i-1]>=B[i]){
                int temp = naturalCost;
                naturalCost= swapCost;
                swapCost = temp+1;
            }// cross array condition failed. do the same what was done in the prev step
            // if swapped in prev step , swap now
            // if not swapped in prev step, donot swap
            else if (A[i-1]>=B[i] || B[i-1]>=A[i]){
                //+1 is to count for the current swap
                swapCost = swapCost+1;
            }else {
                // a1<a2 && b1<b2 && a1<b2 && b1<a2 ==> we can do anything we want to a2 b2
                // irrespective of what was done for a1 b1, we can either swap or leave a2 b2 as it is.
                // but for the cost, we will consider only the min from the prev step.
                int min = Math.min(naturalCost,swapCost);
                naturalCost = min;
                swapCost = min+1;
            }
        }
        return Math.min(naturalCost,swapCost);
    }
}
