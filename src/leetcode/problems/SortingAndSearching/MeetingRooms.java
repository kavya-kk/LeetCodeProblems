package leetcode.problems.SortingAndSearching;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static void main(String[] str){
        int[][] intervals = {{4,7},{4,17},{7,10}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length ==0 || intervals[0].length==0){
            return 0;
        }
        // sort meetings based on their starting times.
        Arrays.sort(intervals, (a, b)-> {
            int comp = a[0]-b[0];
            return comp ==0? a[1]-b[1] : comp;
        });

        int roomCount = 0;
        // store end times of meetings that are currently happening.
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i =0;i<intervals.length;i++){
            if(!q.isEmpty()){
                int earliestEnd = q.peek();
                if(earliestEnd <= intervals[i][0]){
                    q.poll();
                    q.add(intervals[i][1]);
                    continue;
                }
            }
            roomCount++;
            q.add(intervals[i][1]);
        }

        return roomCount;
    }
}
