package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class PairsOfGivenSum {
    public static void main(String[] s){
        int[] a = {20,50,40,25,30,10};
        int target = 90;
        int[] ar=pairWithGivenSum(a,target);
        System.out.print(ar[0]+","+ar[1]);
    }

    // returns a pair with max number among pairs creating target-30 as sum
    public static int[] pairWithGivenSum(int[] a, int target){
        int[] res = {-1,-1};
        int virTarget = target-30;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<a.length; i++) {
            if(map.containsKey(virTarget-a[i])){
                int iComp = map.get(virTarget-a[i]);
                if(res[0]==-1){
                    res[0] = iComp;
                    res[1] = i;
                }else if(a[i]!=a[iComp]){
                    if(a[res[0]] < a[i] || a[res[0]]< a[iComp] ||
                            a[res[1]] < a[i] || a[res[1]]< a[iComp]){
                        res[0] = iComp;
                        res[1] = i;
                    }
                }
            }
            map.put(a[i],i);
        }
        return res;
    }
}
