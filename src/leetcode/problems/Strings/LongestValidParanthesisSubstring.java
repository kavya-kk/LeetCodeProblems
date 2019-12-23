package leetcode.problems.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LongestValidParanthesisSubstring {

    public static void main(String[] str){
        System.out.println(longestValidParentheses("(()"));
    }
    public static int longestValidParentheses(String s) {
        if(s.length() ==0){
            return 0;
        }
        Stack<Integer> openStack = new Stack<>();
        //Stack<Integer> closeStack = new Stack<>();

        List<Integer[]> intervals = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);

            if(c =='('){
                openStack.push(i);
            }else {
                if(openStack.isEmpty()){
                    continue;
                }else {
                    Integer[] interval = new Integer[]{openStack.pop(),i};
                    intervals.add(interval);
                }
            }
        }
        if(intervals.size() ==0){
            return 0;
        }
        if(intervals.size() ==1){
            Integer[] inter = intervals.get(0);
            return inter[1]-inter[0]+1;
        }

        Collections.sort(intervals,(a, b)-> (a[0]-b[0]));
        // merging the intervals to find maxLenSubString
        Integer[] prev = intervals.get(0);
        int curLen = prev[1]-prev[0]+1;
        int maxLen = curLen;
        for(int i =1;i<intervals.size();i++){
            Integer[] interval = intervals.get(i);
            if(prev[0] < interval[0] && (prev[1] > interval[0] || prev[1] == interval[0]-1)){
                prev[0] = Math.min(prev[0],interval[0]);
                prev[1] = Math.max(interval[1],prev[1]);
                curLen =prev[1]-prev[0]+1;
                maxLen =Math.max(curLen,maxLen);
            }else
                prev = interval;
        }


        return maxLen;
    }
}
