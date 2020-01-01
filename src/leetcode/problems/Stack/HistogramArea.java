package leetcode.problems.Stack;

import java.util.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram
public class HistogramArea {
    public static void main(String[] str){
        int[] arr= {2,4,3,1,4,1,4};
        System.out.println(largestRectangleArea(arr));
    }

    private static int maxArea = 0;
    private static Stack<Integer> stk;
    public static int largestRectangleArea(int[] heights) {
        stk = new Stack<>();
        if(heights.length ==0){
            return maxArea;
        }

        for(int i =0;i<heights.length;i++){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i] ){
                calculateArea(heights, i);
            }
            if(stk.isEmpty() || heights[stk.peek()] < heights[i]){
                stk.push(i);
            }
        }

        while(!stk.isEmpty()){
            calculateArea(heights, heights.length);
        }
        return maxArea;
    }

    private static void calculateArea(int[] heights,int i){
        int popped =stk.pop();
        if(stk.isEmpty()){
            int area = heights[popped]*i;
            maxArea = Math.max(maxArea, area);
        }else {
            int area = heights[popped] * (i-stk.peek()-1);
            maxArea = Math.max(maxArea, area);
        }
    }
}
