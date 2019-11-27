package leetcode.problems.Array;
//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchNumberInMatrixII  {
    public static void main(String[] s){
        int[][] a = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(a,-1));
    }
    public static boolean searchMatrix(int[][] a, int target) {
        if(a.length==0 || a[0].length==0){
            return false;
        }
        int r=0, c=a[0].length-1;
        while (r<a.length && c>-1) {
            if(a[r][c] == target){
                return true;
            }else if(a[r][c] > target){
                c--;
            }else {
                r++;
            }
        }
        return false;
    }
}
