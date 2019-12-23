package leetcode.problems.DynamicProgramming;

//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public static void main(String[] str){
        int[] nums = {3,2,1,1,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        // last idx can be reached from last index; so this becomes base case
        int idxToReach = n-1;
        for(int i = n-2;i>=0;i--){
            if(nums[i]+i >= idxToReach){
                idxToReach = i;
            }
        }

        return idxToReach ==0;
    }
}
