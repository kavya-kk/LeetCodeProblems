package leetcode.problems;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    private static PriorityQueue<Integer> q;
    static int K;
    public static void main(String[] s){

        int nums[] = {23,34,12,24};
        K = 3;
        q = new PriorityQueue<>(K);
        getKthLargest(K,nums);

    }
    public static void getKthLargest(int k, int[] nums) {
        for (int a:
             nums) {
           System.out.println("Returned" +add(a));
        }
    }

    public static int add(int n) {
        if (q.size() < K) {
            System.out.println("Adding "+n);
            q.offer(n);
        }
        else if (q.peek() < n) {
            System.out.println("Removing "+q.poll());
            System.out.println("And Adding "+n);
            q.offer(n);
        }
        return q.peek();
    }
}
