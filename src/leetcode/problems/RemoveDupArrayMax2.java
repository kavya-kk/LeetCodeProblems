package leetcode.problems;

public class RemoveDupArrayMax2 {
    public static void main(String[] str){
        int[] arr = {0,0,1,1,1,1,2,3,3,4,4,4};
        int len = removeDuplicates(arr);
        System.out.println(len);
        for(int i =0;i<len; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int removeDuplicates(int[] nums){
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
