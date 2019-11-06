package leetcode.problems;

public class Merge2SortedArrays {
    public static void main(String[] s){
        int[] a = {6,7,8,0,0,0,0,0};
        int[] b = {1,2,3,4,5};
        int m=3, n = 5;
        merge2SortedArrays(a,m,b,n);
        for (int i = 0 ; i<=m+n-1; i++) {
            System.out.print(a[i]+",");
        }
    }

    public static void merge2SortedArrays(int[] a, int m , int[] b, int n){
        int i = m-1, j = n-1, idx = m+n-1;
        while(i>-1&&j>-1){
            a[idx--] = b[j]> a[i] ? b[j--]: a[i--];
        }
        while(j>-1 && idx>-1){
            a[idx--] = b[j--];
        }
    }
}
