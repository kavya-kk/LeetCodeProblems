package leetcode.problems.Stack;

import java.util.Stack;

//https://leetcode.com/problems/trapping-rain-water/
public class WaterTrap {

    public static void main(String[] ge) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    private static int trap(int[] h) {
        int capacity = 0;
        if(h.length ==0){
            return capacity;
        }
        Stack<Integer> stk = new Stack<>();
        for(int i =0;i<h.length; i++){
            // while stack has something && if capacity computation is possible.
            while(!stk.isEmpty() && h[stk.peek()] < h[i]){
                int ele = stk.pop();
                if(!stk.isEmpty()){
                    int height = Math.min(h[stk.peek()],h[i])-h[ele];
                    int width = i-stk.peek()-1;
                    capacity+=height*width;
                }
            }
            if(stk.isEmpty() || h[stk.peek()] >= h[i]){
                stk.push(i);
            }
        }
        return capacity;
    }

}