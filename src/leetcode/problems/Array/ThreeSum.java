package leetcode.problems.Array;

import java.util.*;
//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public static void main(String[] str){
        int[] arr = {-1,-1,2,0,-4};
        threeSum(arr);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        // to avoid finding duplicate triplets
        Set<Integer> visitedNumbers = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length ==0){
            return res;
        }

        Arrays.sort(nums);

        // for each element in the array find the other two numbers that will add up to a number which is a negated value.
        for(int i=0;i<nums.length;i++){
            if(visitedNumbers.contains(nums[i])){
                continue;
            }
            visitedNumbers.add(nums[i]);
            // find all possible pairs of other two numbers
            List<List<Integer>> twoSumRes = twoSum(nums,-nums[i],i+1,nums.length-1);
            for(List<Integer> list: twoSumRes){

                list.add(nums[i]);
                Collections.sort(list);
                if(res.contains(list)){
                    continue;
                }
                res.add(list);
            }
        }
        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start, int end){
        List<List<Integer>> res = new ArrayList<>();
        if(start >= end){
            return res;
        }

        Set<Integer> seen = new HashSet<>();
        for(int i =start;i<=end;i++){
            int cur = nums[i];
            if(seen.contains(target-cur)){
                List<Integer> list = new ArrayList<>();
                list.add(target-cur);
                list.add(cur);
                res.add(list);
                seen.remove(target-cur);
            }else {
                seen.add(cur);
            }
        }
        return res;
    }
}
