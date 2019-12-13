package leetcode.problems.Array;

//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    public static void main(String[] s){
        int[][] mat = {{7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},{9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},{8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},{6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},{7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},{9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},{1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},{3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},{1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},{5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},{2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},{0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}};
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
