package leetcode.problems.DynamicProgramming;

public class MaximalAreaRectangle {
    public static void main(String[] str) {
        char[][] matrix = {
                {'0','1'}
        };
        System.out.println(maximalRectangle(matrix));
    }
    public static int maxArea = 0;
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length ==0 || matrix[0].length ==0){
            return maxArea;
        }
        Data[][] datMatrix = helper(matrix);

        for(int i =0;i< datMatrix.length;i++){
            for(int j =0;j<datMatrix[0].length;j++){
                if(datMatrix[i][j] != null){
                    getMaxArea(datMatrix, i,j);
                }
            }
        }
        return maxArea;
    }

    private static void getMaxArea(Data[][] A, int r, int c){
        Data d = A[r][c];
        int len = d.right;
        int hei = d.down;
        if(len ==0 && hei ==0){
            maxArea = Math.max(maxArea,1);
            return;
        }
        // consider the line creating a rectangle of (len and height 1) or (length 1 and hei)
        maxArea = Math.max(maxArea, Math.max(len+1,hei+1));

        // check along the column for the lengths to compute area.
        for(int i = 1; i <= hei && len >0; i++){
            //check for the length of the below element
            Data below = A[r+i][c];
            len = Math.min(len,below.right);
            maxArea = Math.max(maxArea, (len+1) * (i+1));
        }
    }

    private static Data[][] helper(char[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        Data[][] datMatrix = new Data[R][C];
        for(int i=R-1;i>=0;i--){
            for(int j=C-1;j>=0;j--){
                if(matrix[i][j] =='0'){
                    datMatrix[i][j] = null;
                    continue;
                }
                if(i == R-1 && j == C-1){
                    datMatrix[i][j] = new Data(0,0);
                }else if (i == R-1 && j!=C-1){
                    Data right = datMatrix[i][j+1];
                    datMatrix[i][j] = new Data(right == null? 0: right.right+1, 0);
                }else if (i !=R-1 && j== C-1) {
                    Data down = datMatrix[i + 1][j];
                    datMatrix[i][j] = new Data(0, down == null ? 0 : down.down + 1);
                } else {
                    Data right = datMatrix[i][j+1];
                    Data down = datMatrix[i + 1][j];
                    datMatrix[i][j] = new Data(right == null? 0: right.right+1, down == null ? 0 : down.down + 1);
                }
            }
        }
        return datMatrix;
    }
}

class Data {
    public int right=0;
    public int down=0;
    public Data(){

    }
    public Data(int right, int down){
        this.right= right;
        this.down = down;
    }
}