package leetcode.problems.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    public static boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        populatedAdjacencyMap(prerequisites,adjMap);

        // 0 -> unvisited, 1-> visiting, 2-> visited;
        int[] state = new int[n];

        for(int i =0;i<n;i++){
            // if the node is unvisited
            if(state[i] == 0){
                if(!dfs(i,-1,state,adjMap)){
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean dfs(int node, int parent, int[] state, Map<Integer, List<Integer>> adj){
        // currently visiting the node;
        state[node] = 1;

        List<Integer> nei = adj.get(node);

        if(nei != null && !nei.isEmpty()){
            for(int to: nei){
                if(state[to] ==1){
                    return false;
                }
                if(!dfs(to,node,state,adj)){
                    return false;
                }
            }
        }
        state[node]=2;
        return true;
    }

    public static void populatedAdjacencyMap(int[][] edges, Map<Integer, List<Integer>> adjacencyMap){
        for(int[] edge: edges){
            if(!adjacencyMap.containsKey(edge[0])){
                adjacencyMap.put(edge[0],new ArrayList<>());
            }
            adjacencyMap.get(edge[0]).add(edge[1]);
        }
    }
}

