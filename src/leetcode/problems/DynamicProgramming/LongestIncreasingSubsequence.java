package leetcode.problems.DynamicProgramming;

import java.util.Arrays;
//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public static void main(String[] s){
        int[] a = {0,8,4,2,12};
        System.out.println(longestIncSequence(a));
    }
    // n2 solution
    public static int lengthOfLIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] =1;
        int len = 0;
        for(int i =1 ; i<nums.length;i++){
            int maxLength = 0;
            for(int j = 0 ; j<i; j++){
                if(nums[i] > nums[j]){
                    maxLength = Math.max(dp[j],maxLength);
                }
            }
            dp[i] = maxLength+1;
            len = Math.max(dp[i],len);
        }
        return len;
    }

    // optimal solution
    private static int longestIncSequence(int[] a){
        int[] dp = new int[a.length];
        int len = 0;
        for(int n : a){
            int index = Arrays.binarySearch(dp,0,len, n);
            if(index <0) {
                index = -(index+1);
            }
            dp[index] = n;
            if(index ==  len){
                len++;
            }
        }
        return len;
    }
}
