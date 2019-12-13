package leetcode.problems.Array;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] s){
        int nums[] = {4,1,-1,-1,2,-1,2,3};
        int k = 2;
        List<Integer>  ints = topKFrequent(nums,k);
        for (int i:
             ints) {
            System.out.print(i+"  ");
        }
    }
    public static List<Integer>  topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        // gather a number's frequency
        for (int number:
             nums) {
            map.put(number, map.getOrDefault(number,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>>  queue= new PriorityQueue<>((a,b)-> (b.getValue()-a.getValue()));

        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            queue.add(entry);
        }
        List<Integer> list = new ArrayList<>();
        while(list.size() <k){
            list.add(queue.poll().getKey());
        }
        return list;
    }

}
