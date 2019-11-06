package leetcode.problems;

public class RemoveValFromArr {

    public static void main(String[] st){
        int[] nums = {3,1,2,3,2,3};
        int val = 3;
        int len = removeElement(nums,val);
        for(int i =0;i<len;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int cur_len = nums.length;
        int i = cur_len-1;
        while (i>=0) {
            if(nums[i] == val){
                if(cur_len-i >1){
                    int j=i;
                    while(j<cur_len-1){
                        nums[j] = nums[j+1];
                        j++;
                    }
                }
                cur_len--;
            }
            i--;
        }
        return cur_len;
    }
}
