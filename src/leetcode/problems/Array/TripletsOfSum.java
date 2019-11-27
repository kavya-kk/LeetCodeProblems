package leetcode.problems.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsOfSum {

    public static void main(String[] s){
        int[] arr = {-1,-1,-1,1,1,1,0,0,0,0,0,0};
        Arrays.sort(arr);
        List<List<Integer>> hello = zeroTriplets(arr);
        for(List<Integer> num: hello){
            for(Integer n: num){
                System.out.print(n+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> zeroTriplets(int[] a){
        List<List<Integer>> res = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        int len = a.length;
        for(int i=0;i<len-2;i++){
            if(a[i]>0){
                break;
            }
            for(int j=i+1;j<len-1;j++){
                int k=j+1;
                while(k<len){
                    if(a[i]+a[j]+a[k] == 0){
                        String s = a[i]+"'"+a[j]+"'"+a[k];
                        if(!strList.contains(s)){
                            List<Integer> t = new ArrayList<>();
                            t.add(a[i]);
                            t.add(a[j]);
                            t.add(a[k]);
                            strList.add(a[i]+"'"+a[j]+"'"+a[k]);
                            res.add(t);
                        }
                    }
                    k++;
                }
            }
        }
        for(String str: strList){
            System.out.print(str+",");
        }
        return res;
    }
}
