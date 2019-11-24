package leetcode.problems;

//https://leetcode.com/discuss/interview-question/364760/
public class MaxNetworkRank {

    public static void main(String[] po){
        int[] A = {1,2,3,3};
        int[] B = {2,3,1,4};

        System.out.println(maxNetworkRank(A,B,4));
    }
    private static int maxNetworkRank(int[] A, int[] B, int N){
        int maxRank = 0;
        int[] nodeRanks = new int[N];
        for(int i =0;i<A.length;i++){
            nodeRanks[A[i]-1]++;
            nodeRanks[B[i]-1]++;
        }

        for(int i =0;i<A.length;i++){
            maxRank = Math.max(maxRank, nodeRanks[A[i]-1]+nodeRanks[B[i]-1]-1);
        }

        return maxRank;
    }
}
