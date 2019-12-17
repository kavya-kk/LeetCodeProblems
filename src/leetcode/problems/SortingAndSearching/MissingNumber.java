package leetcode.problems.SortingAndSearching;
//https://leetcode.com/problems/missing-number/
public class MissingNumber {

    public static void main(String[] str){
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        if(n ==0){
            return 0;
        }
        int arrSum =0;
        for(int num: nums){
            arrSum+=num;
        }

        int expectedSum = (n*(n+1))/2;

        return expectedSum - arrSum;
    }
}
