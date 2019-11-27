package leetcode.problems;

import java.util.HashSet;

//https://leetcode.com/discuss/interview-question/401826/
public class LargestNumberWithNegativePair {
    public static void main(String[] s){
        int[] arr = {-41,3,2,5,41};
        System.out.println(largestNumWithNegPair(arr));
    }
    private static int largestNumWithNegPair(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int curMax = 0;
        for (int a:
             arr) {
            // if the negated counter part is already existing, consider the number for largestNum selection.
            if(set.contains(a*-1))
                curMax = Math.max(curMax,Math.abs(a));
            else
                // keep track of numbers read so far.
                set.add(a);
        }
        return curMax;
    }
}
