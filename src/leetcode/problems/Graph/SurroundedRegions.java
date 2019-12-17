package leetcode.problems.Graph;

//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    static int R =0, C=0;
    public static void main(String[] s){
        char[][] grid = {
                {'O','X','X','X','O'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','O','X','X','X'},
                {'X','X','O','O','O'}};
        solve(grid);
        System.out.println();
        System.out.println("RESULT");
        for(int i=0;i<R; i++){
            System.out.println();
            for(int j =0;j<C;j++){
                System.out.print(grid[i][j]+" ");
            }
        }


    }

    private static void solve(char[][] grid){
        R = grid.length;
        if(R == 0 || grid[0].length == 0){
            return ;
        }
        C =grid[0].length;

        for(int i=0;i<R; i++){
            for(int j =0;j<C;j++){
                if((i==0 || j==0 || i==R-1 || j== C-1) && grid[i][j] == 'O'){
                    dfs(grid,i,j);
                }
            }
        }

        for(int i=0;i<R; i++){
            for(int j =0;j<C;j++){
                if(grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }else if(grid[i][j] == '*'){
                    grid[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] grid, int i, int j){
        if(i<0 || i>R-1 || j<0 || j>C-1){
            return;
        }
        if(grid[i][j]== 'X' || grid[i][j]== '*'  ){
            return;
        }
        grid[i][j] = '*';

        dfs(grid,i,j-1);
        dfs(grid, i, j+1);
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
    }
}


