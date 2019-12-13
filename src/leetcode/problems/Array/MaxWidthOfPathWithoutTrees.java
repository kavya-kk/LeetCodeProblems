package leetcode.problems.Array;

import java.util.Arrays;

//https://leetcode.com/discuss/interview-question/447448/
public class MaxWidthOfPathWithoutTrees {
    public static void main(String[] str){
        int[] X = {2,3,4,7,7,7};
        int[] Y = {3,4,2,3,1,3};
        System.out.println(findMaxWidthPathWithoutTrees(X,Y));
    }

    private static int findMaxWidthPathWithoutTrees(int[] X, int[] Y){
        int maxWidth = 0;
        if(X == null){
            return maxWidth;
        }
        Arrays.sort(X);
        for(int i=1;i<X.length;i++){
            maxWidth = Math.max(maxWidth,X[i] - X[i-1]);
        }
        return maxWidth;
    }
}
