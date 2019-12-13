package leetcode.problems.Array;

import java.util.ArrayList;
import java.util.List;

public class SubsetGeneration {
    static List<List<Integer>> subsets = new ArrayList<>();
    public static void main(String[] str){
        int[] a = {1,2,3,4,5};

        findAllSubsets(a);
        System.out.println(subsets.size());
        for (List<Integer> list:
             subsets) {
            System.out.println(list.toString());
        }

    }

    public static void findAllSubsets(int[] a){
        subsets = new ArrayList<>();
        if(a.length == 0){
            return;
        }
        helper(a,0,new ArrayList<>());
    }

    public static void helper(int[] a, int startIdx,List<Integer> subset){
        subsets.add(subset);
        for (int i =startIdx;i<a.length;i++){
            List<Integer> nSet = new ArrayList<>(subset);
            nSet.add(a[i]);
            helper(a,i+1,nSet);
        }
    }
}
