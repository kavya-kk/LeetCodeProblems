package leetcode.problems.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AbsoluteValueSort {

    public static void main(String[] args) {
        int[] arr = {7, -7, 2, -2, 0};
        absSort(arr);
        for(int a: arr){
            System.out.print(a+" ");
        }
    }

    static int[] absSort(int[] arr) {
        if(arr.length <= 1){
            return arr;
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new CustomComparator());
        for(int a: arr){
            q.offer(a);
        }
        int i =0;
        while(!q.isEmpty()){
            arr[i] = q.poll();
            i++;
        }
        return arr;
    }



    static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b){
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if(absA == absB){
                return a-b;
            }else {
                return absA - absB;
            }
        }
    }
}

