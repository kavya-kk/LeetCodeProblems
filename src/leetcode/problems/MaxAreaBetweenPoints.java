package leetcode.problems;

public class MaxAreaBetweenPoints {

    public static void main(String[] ge) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    private static int maxArea(int[] height){
        int maxArea = 0;
        for(int i=0, j=height.length-1;i<j;){
            maxArea = Math.max(maxArea,Math.min(height[i],height[j]) * (j-i));
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }
}