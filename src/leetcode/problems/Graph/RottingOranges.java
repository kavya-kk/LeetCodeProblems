package leetcode.problems.Graph;

import java.util.*;
//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    public static void main(String[] str){
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(grid));
    }

    private static int orangesRotting(int[][] grid){
        int hours = 0;
        if(grid.length == 0 || grid[0].length==0){
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        // initial number of good oranges.
        int count =0;
        Queue<Cell> q  = new LinkedList<>();
        Map<Cell,Integer> hourMap = new HashMap<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2){
                    Cell c = new Cell(i,j, i*rows+j);
                    q.offer(c);
                    hourMap.put(c,c.code);
                }else if (grid[i][j] == 1){
                    count++;
                }
            }
        }

        Cell[] dirs = new Cell[4];
        dirs[0] = new Cell(0,1,0);
        dirs[1]= new Cell(1,0,0);
        dirs[2] = new Cell( -1,0,0);
        dirs[3] = new Cell(0,-1,0);
        while(!q.isEmpty()){
            Cell rottenOrange = q.poll();
            for (Cell dir:
                 dirs) {
                int newRow = dir.row+rottenOrange.row;
                int newCol = dir.col+rottenOrange.col;
                if(newRow < rows && newRow >=0 && newCol < cols && newCol >=0 && grid[newRow][newCol] == 1){
                        count--;
                        grid[newRow][newCol] = 2;
                        Cell c = new Cell(newRow,newCol,rottenOrange.code+1);
                        q.offer(c);
                        hours = c.code;
                }
            }
        }
        if(count > 0){
            return -1;
        }
        return hours;
    }
    static class Cell {
        int row;
        int col;
        int code;
        Cell(int row, int col, int code){
            this.row = row;
            this.col = col;
            this.code = code;
        }
    }
}
