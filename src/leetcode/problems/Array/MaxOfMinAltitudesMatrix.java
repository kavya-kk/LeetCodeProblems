package leetcode.problems.Array;

//https://leetcode.com/discuss/interview-question/383669/
public class MaxOfMinAltitudesMatrix {
    public static void main(String[] s){
        int[][] a = {{5,4,5},
                     {1,2,6},
                     {7,4,6}};
        System.out.println(sol(a));
    }
    private static int sol (int[][] a){
        int rows = a.length;
        int cols = 0;
        if(rows ==0 && a[0].length ==0){
            return 0;
        }
        cols = a[0].length;
        int[][] mat = new int[rows][cols];
        for (int i=rows-1; i>=0;i--){
            for(int j=cols-1; j>=0;j--){
                if(i==rows-1 && j==cols-1){
                    mat[i][j] = Integer.MAX_VALUE;
                }else if (i==rows-1 && j!=cols-1){
                    mat[i][j] = Math.min(a[i][j],mat[i][j+1]);
                }else if (i!=rows-1 && j==cols-1){
                    mat[i][j] = Math.min(a[i][j],mat[i+1][j]);
                }else if (i!=rows-1 && j!=cols-1){
                    int n = a[i][j];
                    if(i==0 && j==0){
                        n=Integer.MAX_VALUE;
                    }
                    mat[i][j] = Math.min(n,Math.max(mat[i+1][j],mat[i][j+1]));
                }
            }
        }
        return mat[0][0];
    }
}
