package leetcode.problems;

import java.util.*;

public class MinimumPathSum {
    public static void main(String[] s){
        int[][] mat = {{7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},{9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},{8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},{6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},{7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},{9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},{1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},{3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},{1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},{5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},{2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},{0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}};
    }

    public static int minimumPath(int[][] a){
        int rMax = a.length;
        if(a.length==0 || a[0].length == 0)
            return 0;
        int cMax = a[0].length;
        // create a temp weight matrix with all values set to max integer.
        int[][] weightMat = new int[rMax][cMax];
        for (int[] row:
             weightMat) {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        weightMat[0][0]= 0;
       Cell start = new Cell(0,0);
        Queue<Cell> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            Cell polled = q.poll();

            for (Cell nei: getNeighbors(polled,rMax,cMax)) {


                weightMat[nei.row][nei.col] = Math.min(weightMat[nei.row][nei.col],
                                                weightMat[polled.row][ polled.col]+a[polled.row][ polled.col]);

                if(!q.contains(nei)){
                    q.offer(nei);
                }

            }
        }

        return (weightMat[rMax-1][cMax-1] + a[rMax-1][cMax-1]);
    }

    private static List<Cell> getNeighbors(Cell parent, int rMax, int cMax){
        List<Cell> neighbors = new ArrayList<>();
        List<Cell> dirs = new ArrayList<>();
        dirs.add(new Cell(0,1));
        dirs.add(new Cell (1,0));
        for (Cell dir:
            dirs ) {

            int row  = parent.row+dir.row;
            int col = parent.col+dir.col;
            if(row<rMax && col<cMax){
                neighbors.add(new Cell(row,col));
            }
        }
        return neighbors;
    }

    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row &&
                    col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
