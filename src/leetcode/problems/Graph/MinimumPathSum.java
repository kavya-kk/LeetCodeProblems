package leetcode.problems.Graph;

//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    public static void main(String[] s){
        int[][] mat = {{5,4,5},{1,2,6},{7,4,6}};
        System.out.println(minimumPath(mat));
    }

    public static int minimumPath(int[][] grid){

        int R = grid.length;
        if(R == 0 || grid[0].length ==0){
            return -1;
        }
        int C = grid[0].length;

        for(int i =0;i<R;i++){
            for(int j=0;j<C;j++){
                if(i == 0 && j ==0){
                    continue;
                }else if (i!=0 && j ==0){
                    grid[i][j]+=grid[i-1][j];
                }else if (i==0 && j !=0){
                    grid[i][j]+=grid[i][j-1];
                }else{
                    int x = Math.min(grid[i-1][j],grid[i][j-1]);
                    grid[i][j]+=x;
                }
            }
        }

        return grid[R-1][C-1];
    }
}
