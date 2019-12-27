package leetcode.problems.Graph;
//https://leetcode.com/problems/number-of-islands
public class NumberOfIslands {

    public static void main(String[] s){
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int R = grid.length;
        if(R == 0){
            return 0;
        }
        int C = grid[0].length;
        int count =0;
        for(int i =0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]=='1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i,int j){
        if(i<0 || j<0 || i>=grid.length || j >= grid[0].length || grid[i][j] =='0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);

    }

}

