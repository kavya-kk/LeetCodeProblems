package leetcode.problems.Array;

import java.util.Arrays;
//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public static void main(String[] s){
        int[] a = {0,8,4,2,12   };
        System.out.println(longestIncSequence(a));
    }
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
