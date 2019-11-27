package leetcode.problems.Graph;

import java.util.*;

public class ArticulationPointInGraph {
    private static int childCount = 0;
    private static Map<Integer,List<Integer>> adjacency = new HashMap<>();
    private static int[] low_link;
    private static int[] ids;
    private static boolean[] isArtPoint ;
    private static boolean[] visited ;
    public static void main(String[] s){
        Integer[][] conArr = {{0,1},{0,3},{1,2},{3,4},{2,5},{5,6},{3,2}};
        int n = 7;
        boolean[] artPoints = findArtPoints(conArr,n);
        for(int i =0;i<n;i++){
            if(artPoints[i]){
                System.out.println(i);
            }
        }
    }

    private static Map<Integer, List<Integer>> populateAdjacency(Integer[][] arr){
        for (Integer[] ar:arr) {
            int node1 = ar[0];
            int node2 = ar[1];
            if(adjacency.containsKey(node1)){
                adjacency.get(node1).add(node2);
            }else {
                List<Integer> nodes = new ArrayList<>();
                nodes.add(node2);
                adjacency.put(node1,nodes);
            }
            if(adjacency.containsKey(node2)){
                adjacency.get(node2).add(node1);
            }else {
                List<Integer> nodes = new ArrayList<>();
                nodes.add(node1);
                adjacency.put(node2,nodes);
            }
        }
        return adjacency;
    }

    private static boolean[] findArtPoints(Integer[][] arr, int n){
        low_link = new int[n];
        ids = new int[n];
        isArtPoint = new boolean[n];
        visited = new boolean[n];
        populateAdjacency(arr);

        for(int i =0;i<n;i++){
            childCount = 0;
            if(!visited[i]) {
                dfs(i, i, -1);
                isArtPoint[i] = (childCount > 1);
            }
        }
        return isArtPoint;
    }

    private static void dfs(int root, int node, int parent){
        if(parent == root){
            childCount++;
        }
        low_link[node] = node;
        ids[node] = node;
        visited[node] = true;
        for (int to : adjacency.get(node)) {
            if(to == parent){
                continue;
            }
            if(!visited[to]){
                dfs(root,to,node);
                low_link[node] =  Math.min(low_link[node],low_link[to]);
                if(ids[node] <= low_link[to]){
                    isArtPoint[node] = true;
                }
            }else {
                low_link[node] = Math.min(low_link[node],ids[to]);
            }
        }
    }

}
