package leetcode.problems.Backtracking;
//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
public class KEqualSumSubsets {
    public static void main(String[] s){
        int[] a = {4,3,1,2,5};
        int k = 3;
        System.out.println(canFormKSubsets(a,k));
    }
    private static boolean canFormKSubsets(int[] a, int k){
        int sum = 0;
        for (int n: a) {
            sum+=n;
        }
        if(k == 0 || k >=a.length || sum%k !=0){
            return false;
        }
        return canPartition(0,a,k,new boolean[a.length],0,sum/k);
    }

    private static boolean canPartition(int startIndex, int[] a, int k, boolean[] used, int curSum, int reqSum){
        // if only one bucket needs to be filled, then partition is possible
        if(k == 1){
            return true;
        }
        if(curSum == reqSum){
            return canPartition(0,a,k-1,used,0,reqSum);
        }

        for(int i =0;i<a.length;i++){
            if(!used[i] && curSum+a[i] <=reqSum){
                used[i] = true;
                if(canPartition(i+1,a,k,used,curSum+a[i],reqSum)){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
