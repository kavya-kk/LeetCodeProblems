package leetcode.problems;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//https://leetcode.com/discuss/interview-question/356981
public class MinimumCostToConnectAllNodes {

    public static void main(String[] aabc){
        int n = 6;
        int[][] edges = {{1, 4}, {4, 5}, {2, 3}},
                newEdges = {{1, 2, 5}, {1, 3, 10}, {1, 6, 12}, {5, 4, 5}};

        System.out.println(getMinCost(n,edges,newEdges));
    }

    private static int getMinCost(int n, int[][] edges, int[][] newEdges){
        int minCost = 0;
        Set<Set<Integer>> comps = new HashSet<>();
        boolean[] nodes = new boolean[n];

        for (int[] e:
            edges ) {
            Set<Integer> comp0 = findComp(e[0],comps);
            nodes[e[0]-1] = true;
            Set<Integer> comp1 = findComp(e[1],comps);
            nodes[e[1]-1] = true;
            comp0.addAll(comp1);
            comps.remove(comp1);
        }
        Set<Integer> leftOverNodes = new HashSet<>();
        for (int i = 1;i<=n;i++) {
            if(!nodes[i-1]){
                findComp(i,comps);
                leftOverNodes.add(i);
            }
        }
        PriorityQueue<int[]> q = getPrioritizedNewEdges(newEdges);
        while(comps.size()>1 && !q.isEmpty()){
            int[] newE = q.poll();
            if(leftOverNodes.contains(newE[0]) || leftOverNodes.contains(newE[1])){
                Set<Integer> comp0 = findComp(newE[0],comps);
                Set<Integer> comp1 = findComp(newE[1],comps);
                if(comp0.equals(comp1)){
                    continue;
                }
                nodes[newE[0]-1] = true;
                nodes[newE[1]-1] = true;
                comp0.addAll(comp1);
                comps.remove(comp1);
                minCost+=newE[2];
            }
        }
        return minCost;
    }

    private static Set<Integer> findComp(int node, Set<Set<Integer>> comps){
        for (Set<Integer> comp:comps) {
            if(comp.contains(node)){
                return comp;
            }
        }
        // if this part of code is reached there is no comp existing with the current node,
        // so create (1) a new comp (2)add cur node to comp (3) add the comp to comps set.
        Set<Integer> comp = new HashSet<>();
        comp.add(node);
        comps.add(comp);
        return comp;
    }

    private static PriorityQueue<int[]> getPrioritizedNewEdges(int[][] newEdges){
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] < o2[2]){
                    return -1;
                }else if (o1[2] > o2[2]){
                    return 1;
                }
                return 0;
            }
        });
        for (int[] edge:
            newEdges ) {
            q.offer(edge);
        }
        return q;
    }

}
