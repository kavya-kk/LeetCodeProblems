package leetcode.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/411357/
public class ZombiesAndHuman {

    public static void main(String[] s){
       int[][] grid =  {{0, 1, 1, 0, 1},
                        {0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0}};
       System.out.println(humanToZombie(grid));
    }

    private static int humanToZombie(int[][] grid){
        int hours =0;
        if(grid.length == 0 || grid[0].length ==0){
            return 0;
        }
        int R = grid.length;
        int C = grid[0].length;
        Queue<Cell> q = new LinkedList<>();
        Map<Integer,Integer> hourMap = new HashMap<>();
        for(int i =0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j] ==1){
                    q.offer(new Cell(i,j));
                    hourMap.put(i*R+j, 0);
                }
            }
        }

        Cell[] dirs = new Cell[4];
        dirs[0] = new Cell(0,1);
        dirs[1]= new Cell(1,0);
        dirs[2] = new Cell( -1,0);
        dirs[3] = new Cell(0,-1);

        while(!q.isEmpty()){
            Cell zombie = q.poll();
            for (Cell dir:
                    dirs) {
                int newRow = dir.row+zombie.row;
                int newCol = dir.col+zombie.col;
                if(newRow < R && newRow >=0 && newCol < C && newCol >=0 && grid[newRow][newCol] == 0){
                    grid[newRow][newCol] = 1;
                    Cell c = new Cell(newRow,newCol);
                    q.offer(c);
                    int zomCode = zombie.row*R+zombie.col;
                    int newCode = newRow*R+newCol;
                    hourMap.put(newCode,hourMap.get(zomCode)+1);
                    hours = hourMap.get(newCode);
                }
            }
        }
        return hours;
    }
    static class Cell {
        int row;
        int col;
        Cell(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
}


