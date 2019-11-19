package leetcode.problems;

//https://www.pramp.com/challenge/N5LYMbYzyOtbpovQoY7X
class NumberOfPaths {

    public static void main(String[] args) {
        System.out.println(numOfPathsToDest(5));
    }

    static int numOfPathsToDest(int n) {
        int[][] rank = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i==0&& j==0){
                    // going backwards considering 0,0 as the source.
                    // ==> paths to reach 0,0 from source is 0
                    rank[i][j] = 1;
                }
                if(j==0 && i!=0){
                    rank[i][j] = rank[i-1][j];
                }
                if(j!=0 && i!=0){
                    rank[i][j] = rank[i-1][j] + rank[i][j-1];
                }
            }
        }
        return rank[n-1][n-1];
    }

}
