package leetcode.problems.Array;

//https://leetcode.com/problems/set-mismatch/
public class SetMismatch {
    public static void main(String[] str){
        int[] nums = {1,2,2,4};

        int[] res = findErrorNums(nums);
        System.out.println(res[0]+","+res[1]);
    }

    public static int[] findErrorNums(int[] nums) {
        int nLen = nums.length;
        int[] result = {-1,-1};

        // find the repeated number
        for(int i = 0;i<nLen;i++){
            //get the abs value of the number at position i since it might have been infected by a different number pointing to this index.
            int val = Math.abs(nums[i]);

            // get the value at val position.
            int x = nums[val-1];

            // if the number is already -ve, then it was infected before, thus pointing that the positionValue (val) is being repeated.
            if(x <0) {
                result[0] = val;
            }else {
                nums[val-1] *= -1;
            }
            //the loop has to continue even after finding the repeated number to infect all the indices to find the missing value.
        }

        // find the number that is missing;
        for(int i =0;i<nLen;i++){
            // the value at the missing index-1(since indices are numbered from 0 to n-1) will still be unaffected.
            if(nums[i] >0){
                result[1] = i+1;
                break;
            }
        }

        return result;
    }
}
