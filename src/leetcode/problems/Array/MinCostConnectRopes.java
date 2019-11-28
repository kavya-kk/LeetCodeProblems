package leetcode.problems.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/discuss/interview-question/344677
public class MinCostConnectRopes {
    public static void main(String[] s){
        Integer[] arr = {2,2,3,3};
        System.out.println(optimalCostConnectRopes(arr));
    }
    private static int optimalCostConnectRopes(Integer[] a){
        if(a.length == 1){
            return a[0];
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.addAll(Arrays.asList(a));
        int cost = 0;
        while(q.size()>1){
            int newE = q.poll()+q.poll();
            q.offer(newE);
            cost+=newE;
        }
        return cost;
    }
}
