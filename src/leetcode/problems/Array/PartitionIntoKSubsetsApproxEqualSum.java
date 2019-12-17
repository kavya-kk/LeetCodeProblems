package leetcode.problems.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/discuss/interview-question/430981/
public class PartitionIntoKSubsetsApproxEqualSum {
    public static void main(String[] str){
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int k = 3;
        List<List<Integer>> subsets = kApproxEqualSumSubsets(arr,k);
        System.out.println(subsets);
    }

    private static List<List<Integer>> kApproxEqualSumSubsets(int[] arr, int k){
        List<List<Integer>> subsets = new ArrayList<>();
        if(arr.length < k){
            //cannot partition since there are no enough elements.
            return subsets;
        }
        int[] sums = new int[k];
        // the queue holds the elements in the increasing order of the subset sum,
        // so that the current element under consideration will be added to the min sum subset thus balancing it out.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {return sums[a] -sums[b];});
        // initialize and create place holders for each subset.
        for(int i =0;i<k;i++){
            pq.add(i);
            subsets.add(new ArrayList<>());
        }
        // keep adding the current element to the subset that is current low in sum.
        for(int i=arr.length-1;i>=0;i--){
            int curIdx = pq.poll();
            sums[curIdx] += arr[i];
            subsets.get(curIdx).add(arr[i]);
            pq.add(curIdx);
        }
        return subsets;
    }
}
