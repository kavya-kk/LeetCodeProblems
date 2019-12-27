package leetcode.problems.Array;

public class NextPermutation {

    public static void main(String[] str){
        int[] nums = {1,2,3};
        nextPermutation(nums);

        System.out.println();
        for(int i: nums){
            System.out.print(i+",");
        }
    }
    public static void nextPermutation(int[] nums) {

        if(nums.length ==1){
            return;
        }
        //traverse backwards and find the position where the value decreases
        int i =nums.length-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }

        // now i will the the first element that is lesser than the value after it.
        // find a number from the right of i that is just higher than the element at i
        if(i>=0){
            int j = nums.length-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }

        // reverse the array from i+1 to end;
        reverse(nums,i+1);

    }

    private static void reverse(int[] nums, int start){
        int end = nums.length-1;
        // reverse by swapping the extreme elements.
        while(start <end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
