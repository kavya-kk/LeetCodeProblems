package leetcode.problems.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals
public class MergeIntervals {
    public static void main(String[] arr){
        int[][] intervals = {{1,3},{2,6},{1,15}};
        for(int[] interval: merge(intervals)){
            System.out.println(interval[0]+","+interval[1]);
        }
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        // sort based on the first value.
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        // consider every two intervals and try merging it with the next.
        List<int[]> res = new ArrayList<>();
        int[] nI = intervals[0];
        res.add(nI);
        for(int[] i: intervals){
            if(i[0] <= nI[1]){
                nI[1] = Math.max(i[1],nI[1]);
            }else {
                nI = i;
                res.add(nI);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
