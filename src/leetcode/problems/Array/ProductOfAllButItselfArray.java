package leetcode.problems.Array;

import java.util.Arrays;

public class ProductOfAllButItselfArray {

    public static void main(String[] s){
        int[] nums = {2,5,4,0};
        for (int n:
                productExceptSelf(nums)) {
            System.out.print(n +" , ");
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        if(len<=1)
            return nums;

        int[] arr = new int[len];
        Arrays.fill(arr,1);
        int prod1=1, prod2=1;
        for(int i=0,j=len-1;i<len && j>=0; i++,j--){
            arr[i] *=prod1;
            arr[j] *=prod2;
            prod1*= nums[i];
            prod2*= nums[j];
        }
        return arr;
    }
}
