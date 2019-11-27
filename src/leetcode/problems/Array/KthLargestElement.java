package leetcode.problems.Array;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] s){
        int nums[] = {23,34,12,24};
        int k = 4;
        System.out.println(findKthLargest(nums,k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        for (int num:
             nums) {
            queue.add(num);
        }
        int i=1;
        while (i<k ){
            queue.poll();
            i++;
        }
        return queue.poll();
    }
}
