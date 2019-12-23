package leetcode.problems.DynamicProgramming;

import java.util.Arrays;
//https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {

    public static void main(String[] str){
        int[] nums = {3,2,1,1,4};
        System.out.println(jump(nums));
    }
    // O(n)
    public static int jumpOpt(int[] nums){
        int len = nums.length;
        if(len <=1){
            return 0;
        }

        int jumps = 0;
        int curFarthest = 0;
        int nextFarthest = nums[0];
        // until reaching the last but one index element should hop,
        for(int i =0;i<len-1;i++){
            nextFarthest = Math.max(nextFarthest,nums[i]+i);
            // if currently considered farthest is reached, try to jump to the captured next farthest.
            if(i == curFarthest){
                jumps++;
                curFarthest = nextFarthest;
            }
        }

        return jumps;
    }
    //O(n^2)
    public static int jump(int[] nums) {
        int len = nums.length;
        if(len <=1){
            return 0;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[len-1] = 0;

        for(int i = len-2;i>=0;i--){
            if(nums[i]+i>=len-1){
                dp[i] =1;
            }else {
                for(int j =1;j<=nums[i];j++){
                    int temp = dp[j+i] == Integer.MAX_VALUE? dp[j+i] : dp[j+i]+1;
                    dp[i] = Math.min(dp[i],temp);
                }
            }
        }
        return dp[0];
    }


}
