package leetcode.problems.Array;

//https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {

    public static void main(String[] s){
        int n = 4;
        int[][] a = generateMatrix(n);
        for(int i =0;i<a.length; i++){
            System.out.println();
            for( int j=0; j<a[0].length; j++){
                System.out.print( a[i][j]);
            }
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        //spiral directions ordering - right, down, left, up.
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int num = 1;
        int nSquared =(int) Math.pow(n,2);
        int curRow =0, curCol = -1; // starting point
        int dir = 0;
        int minR= 0, minC = 0, maxR = n-1, maxC = n-1;
        while(num <= nSquared ){
            curRow = curRow+dirs[dir][0];
            curCol = curCol+dirs[dir][1];
            System.out.println("Giving row:"+curRow+" col:"+curCol+" Value:"+num);
            mat[curRow][curCol] = num;
            // if we are moving right and have reached the largest unfilled column
            if(dir == 0 && curCol == maxC){
                // Row from above is full;
                minR++;
                dir++;
            }else if (dir ==1 && curRow == maxR){
                maxC--;
                dir++;
            }else if (dir ==2 && curCol == minC){
                maxR--;
                dir++;
            }else if (dir == 3 && curRow == minR){
                minC++;
                dir =0;
            }
            num++;
        }
        return mat;
    }
}
