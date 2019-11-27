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
        for (int number:
             nums) {
            if(map.containsKey(number)){
                map.put(number,map.get(number)+1);
            }else {
                map.put(number,1);
            }
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
