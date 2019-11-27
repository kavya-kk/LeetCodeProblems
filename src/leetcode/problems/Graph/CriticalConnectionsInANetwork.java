package leetcode.problems.Graph;

import java.util.*;

//https://leetcode.com/problems/critical-connections-in-a-network/
//https://www.youtube.com/watch?v=aZXi1unBdJA - TARJANs algorithm.
//https://iq.opengenus.org/tarjans-algorithm/
public class CriticalConnectionsInANetwork {
    static int[] ids ;
    static int[] lowLink;
    static boolean[] visited;
    static Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    public static void main(String[] s){
        Integer[][] conArr = {{4,3},{5,4},{3,5},{4,1},{2,1}};
        List<List<Integer>> connections = new LinkedList<>();
        for (Integer[] a:
             conArr) {
            connections.add(Arrays.asList(a));
            populateAdjacencyMap(a[0]-1,a[1]-1);
           // populateAdjacencyMap(a[1]-1,a[0]-1);
        }
        int n = 5;
        for (List<Integer> bridge:
        criticalConnections(n,connections)) {
            System.out.println((bridge.get(0)+1)+","+(bridge.get(1)+1));
        }
    }

    private static void populateAdjacencyMap(Integer a, Integer b) {
        if(!adjacencyMap.containsKey(a)){
            adjacencyMap.put(a, new ArrayList<>());
        }
        List<Integer> li = adjacencyMap.get(a);
        if(!li.contains(b)){
            li.add(b);
        }
    }

    private static void init(int n){
        lowLink = new int[n];
        ids = new int[n];
        visited = new boolean[n];
        Arrays.fill(visited, false);
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        init(n);
        List<List<Integer>> bridges = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(!visited[i])
                dfs(i,-1,bridges);
        }
        return bridges;
    }


    private static void dfs(int id, int parent,  List<List<Integer>> bridges){
        System.out.println("Visiting node:"+id+" whose parent is:"+parent);
        visited[id] = true;
        ids[id] = id;
        lowLink[id] = id;
        // FROM the current node TO all its neighbours
        if(adjacencyMap.get(id) == null){
            return;
        }
        for (int to: adjacencyMap.get(id)) {
            // if the node is not visited
            if(to==parent){
                continue;
            }
            if(!visited[to]){
                // if the adjacent node is not the current nodes parent the below should happen.
                // visit it
                dfs(to,id,bridges);
                //adjust the lowLink value of the current node.
                lowLink[id] = Math.min(lowLink[id], lowLink[to]);
                // add the edge to bridges based on the fact.
                if(ids[id] < lowLink[to]){
                    List<Integer> edge = new ArrayList<>();
                    edge.add(id);
                    edge.add(to);
                    bridges.add(edge);
                }
            }else {
                lowLink[id] = Math.min(lowLink[id], ids[to]);
            }
        }
    }
}
