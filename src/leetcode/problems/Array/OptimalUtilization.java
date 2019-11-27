package leetcode.problems.Array;

import java.util.*;

//https://leetcode.com/discuss/interview-question/373202
public class OptimalUtilization {
    public static void main(String[] s){

        Integer[][] aArr = {{1,8},{2,15},{3,9}};
        Integer[][] bArr = {{1,8},{2,11},{3,12}};
        List<Integer[]> a = Arrays.asList(aArr);
        List<Integer[]> b = Arrays.asList(bArr);
        int target = 20;
        for (Integer[] arr: optimalUsage(a,b, target)) {
            System.out.println(arr[0]+","+arr[1]);
        }
    }

    private static List<Integer[]> optimalUsage(List<Integer[]> a,List<Integer[]> b , int target){
        List<Integer[]> sol = new ArrayList<>();
        // diff Vs List of points map
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        sortAB(a,b);
        int aId = a.size()-1, bId = 0;
        while(aId>=0 && bId <b.size()){
            int curTar = a.get(aId)[1]+b.get(bId)[1];
            if(curTar <= target){
                int diff = target-curTar;
                Integer[] ar = {a.get(aId)[0],b.get(bId)[0]};
                if(!map.containsKey(diff)){
                    List<Integer[]> arList = new ArrayList<>();
                    map.put(diff, arList);
                }
                map.get(diff).add(ar);
                bId++;
            }else {
                aId--;
            }
        }

        return map.get(getOptimal(map));
    }

    private static int getOptimal(Map<Integer, List<Integer[]>> map){
        List<Integer> list = new ArrayList<>();
        list.addAll(map.keySet());
        Collections.sort(list);
        return list.get(0);
    }

    private static void sortAB(List<Integer[]> a,List<Integer[]> b){
        Comparator<Integer[]> comp = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] one, Integer[] two) {
                if(one[1]>two[1])
                    return 1;
                else if (one[1]<two[1])
                    return -1;
                return 0;
            }
        };
        Collections.sort(a, comp);
        Collections.sort(b, comp);
    }


}
