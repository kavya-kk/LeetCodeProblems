package leetcode.problems.Array;

import java.util.Arrays;
//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    public static void main(String[] s){
        int[] nums={-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length <3)
            return Integer.MAX_VALUE;

        int res = nums[0]+nums[1]+ nums[nums.length-1];
        Arrays.sort(nums);
        for(int i =0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start <end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum > target){
                    end--;
                }else {
                    start++;
                }
                if(Math.abs(sum-target) < Math.abs(res-target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
