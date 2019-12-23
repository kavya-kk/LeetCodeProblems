package leetcode.problems.Graph;
//https://leetcode.com/discuss/interview-question/451482/
public class JumpGameIII {

    public static void main(String[] str){
        int[] nums= {3,4,3,0,3,1,2,1};
        int start = 7;
        System.out.println(canJump(nums,start));
    }

    public static boolean canJump(int[] nums, int startPosition){
        int len = nums.length;
        if(len <=startPosition){
            return false;
        }
        boolean[] visited = new boolean[len];

        return canJumpHelper(nums,startPosition,visited);
    }

    private static boolean canJumpHelper(int[] nums, int cur, boolean[] visited){
        if(cur < 0 || cur >=nums.length || visited[cur]){
            return false;
        }
        if(nums[cur] == 0){
            return true;
        }
        visited[cur] = true;
        return canJumpHelper(nums, cur - nums[cur], visited) || canJumpHelper(nums, cur + nums[cur], visited) ;
    }
}
