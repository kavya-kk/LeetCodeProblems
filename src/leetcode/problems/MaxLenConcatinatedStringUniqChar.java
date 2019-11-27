package leetcode.problems;
//https://leetcode.com/discuss/interview-question/401826/
import java.util.*;

public class MaxLenConcatinatedStringUniqChar {
    private static  Map<Integer, List<Integer>> adjMap = new HashMap<>();
    private static boolean[] visited;
    public static void main(String[] s){
        String[] arr = {"abc","ade","akl"};
        System.out.println(maxLength(Arrays.asList(arr)));
    }

    private static int maxLength(List<String> arr){
        int maxLen = -1;
        populateAdjacency(arr);
        for(Integer i: adjMap.keySet()){
            int len = dfs(i,-1,arr, arr.get(i));
            if(len == arr.get(i).length()){
                len = 0;
            }
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }

    private static int dfs(int cur, int par,List<String> arr, String soFar){
        int maxLen=soFar.length();
        List<Integer> adjList = adjMap.get(cur);
        if(adjList.size() == 0){
            if(isConnected(soFar,"")){
                return maxLen;
            }else {
                return -1;
            }
        }
        for(int nei :adjList){
            if(nei == par){
                continue;
            }
            if(isConnected(arr.get(nei),soFar)){
                maxLen = Math.max(maxLen,dfs(nei,cur,arr,soFar+arr.get(nei)));
            }
        }
        return maxLen;
    }

    private static void populateAdjacency(List<String> ar){
        for(int i=0;i<ar.size();i++){
            if(adjMap.get(i) == null){
                adjMap.put(i,new ArrayList<>());
            }
            for(int j = i+1;j<ar.size();j++){
                if(isConnected(ar.get(i),ar.get(j))){
                    if(!adjMap.containsKey(i)){
                        List<Integer> newList = new ArrayList<>();
                        adjMap.put(i,newList);
                    }
                    adjMap.get(i).add(j);
                    if(!adjMap.containsKey(j)){
                        List<Integer> newList = new ArrayList<>();
                        adjMap.put(j,newList);
                    }
                    adjMap.get(j).add(i);

                }
            }
        }
    }
    private static boolean isConnected(String a, String b){
        Set<Character> set = new HashSet<>();
        for (Character c:
             a.toCharArray()) {
            if(set.contains(c)){
                return false;
            }else {
                set.add(c);
            }
        }
        for(Character c: b.toCharArray()){
            if(set.contains(c)){
                return false;
            }else {
                set.add(c);
            }
        }
        return true;
    }

}
