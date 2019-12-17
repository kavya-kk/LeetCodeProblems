package leetcode.problems.DynamicProgramming;
//https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionEqualSumSubset {
    public static void main(String[] str){
        int[] a = {4,3,2,1};
        System.out.println(canPartition(a));
    }
    public static boolean canPartition(int[] arr){
        int sum  =0 ;
        for(int a: arr){
            sum+=a;
        }
        if(sum == 1 || sum%2 == 1){
            return false;
        }

        sum/=2;
        int n = arr.length;
        boolean[][] ks = new boolean[n+1][sum+1];

        ks[0][0] = true;
        for(int i =1;i<ks.length;i++){
            ks[i][0] = true;
        }
        for(int i =1;i<ks.length;i++){
            for(int j =1; j<ks[0].length;j++){
                if(j-arr[i-1] >=0 && j-arr[i-1] < ks[0].length)
                    ks[i][j] = ks[i-1][j] || ks[i-1][j-arr[i-1]];
                else
                    ks[i][j] = ks[i-1][j];
            }
        }
        return ks[n][sum];
    }
}
