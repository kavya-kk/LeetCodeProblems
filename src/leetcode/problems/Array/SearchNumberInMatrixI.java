package leetcode.problems.Array;
//https://leetcode.com/problems/search-a-2d-matrix/
public class SearchNumberInMatrixI {
    public static void main(String[] s){
        int[][] a = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(a,15));
    }
    public static boolean searchMatrix(int[][] a, int target) {
        if(a.length ==0 || a[0].length ==0){
            return false;
        }
        int minR = 0 , minC = 0;
        int maxR = a.length-1, maxC = a[0].length-1;
        while(minR <= maxR){
            int midR= (minR+maxR)/2;
            if(target == a[midR][0]){
                return true;
            } else if(target < a[midR][0]){
                maxR = midR-1;
            } else {
                if(target <= a[midR][maxC]){
                    return binarySearch(a[midR],target);
                }else {
                    minR = midR+1;
                }
            }
        }

        return false;
    }

    public static boolean binarySearch(int[] a , int target){
        int min = 0, max = a.length-1;
        while(min<=max){
            int mid = (min+max)/2;
            if(target == a[mid]){
                return true;
            }else if(target < a[mid]){
                max = mid-1;
            }else {
                min = mid+1;
            }
        }
        return false;
    }
}
