package leetcode.problems.Array;
//https://leetcode.com/problems/single-number/
public class SingleNumber {
    public static void main(String[] str){
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
    public static int singleNumber(int[] nums) {
        int x = nums[0];
        for(int i =1;i<nums.length;i++){
            x^=nums[i];
        }
        return x;
    }
}
