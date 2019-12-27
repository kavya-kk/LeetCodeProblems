package leetcode.problems.SortingAndSearching;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class StartAndEndIdx {

    public static void main(String[] str){
        int[] nums = {5,14,16,21,22,22,22};
        int[] result = searchRange(nums,22);
        System.out.println(result[0]+","+result[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};

        if(nums.length ==0){
            return res;
        }
        int startIdx = findIdx(nums,target,true);
        if(startIdx == nums.length || nums[startIdx]!=target){
            return res;
        }
        res[0] = startIdx;
        int right = findIdx(nums,target,false);

        res[1] = (nums[right] == target) ? right: right-1 ;


        return res;
    }

    private static int findIdx(int[] nums, int target, boolean left){
        int start = 0, end = nums.length-1;

        while(start < end){
            int mid = (end+start)/2 ;
            if(nums[mid] > target || (left && nums[mid] == target)){
                end = mid;
            }else {
                start = mid+1;
            }
        }
        return start;
    }
}
