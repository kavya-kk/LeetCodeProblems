package leetcode.problems.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixI {
    public static void main(String[] s){
        int[][] mat = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        List<Integer> list = spiralOrder(mat);
        System.out.println();
        for (int i =0; i<mat.length*mat[0].length; i++) {
            System.out.print(list.get(i)+",");
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        // reading directions right, down, left, up
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int num = 0;
        if(matrix.length==0 || matrix[0].length ==0){
            return spiral;
        }
        int m = matrix.length, n = matrix[0].length;
        int minR= 0, minC = 0, maxR = m-1, maxC = n-1;
        int curRow = 0, curCol = -1;
        int dir = 0;
        while(num < (n*m)){
            curRow = curRow+dirs[dir][0];
            curCol = curCol+dirs[dir][1];
            spiral.add(matrix[curRow][curCol]);
            if(dir == 0 && curCol == maxC){
                minR++;
                dir++;
            }else if (dir ==1 && curRow == maxR){
                maxC--;
                dir++;
            }else if (dir ==2 && curCol == minC){
                maxR--;
                dir++;
            }else if (dir ==3 && curRow == minR){
                minC++;
                dir=0;
            }
            num++;
        }
        return spiral;
    }
}

