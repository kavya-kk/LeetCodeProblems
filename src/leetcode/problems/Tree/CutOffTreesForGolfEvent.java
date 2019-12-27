package leetcode.problems.Tree;

import java.util.*;

//https://leetcode.com/problems/cut-off-trees-for-golf-event/
public class  CutOffTreesForGolfEvent {

    static int R = 0;
    static int C = 0;
    static int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    public static void main(String[] args){
        Integer[][] arr = {{1,2,3},{4,5,6},{0,0,1}};

        List<List<Integer>> forest = new ArrayList<>();
        for(Integer[] a: arr){
            forest.add(Arrays.asList(a));
        }
        System.out.println(cutOffTree(forest));
    }
    public static int cutOffTree(List<List<Integer>> forest) {
        R = forest.size();
        if(R ==0 || forest.get(0).size() ==0){
            return 0;
        }
        C = forest.get(0).size();
        //store trees and their locations in the increasing order of tree heights;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        // trees should be cut in this order.
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                // treeheight, row, col;
                int cur = forest.get(i).get(j);
                if(cur!=0)
                    q.add(new int[]{cur,i,j});
            }
        }
        int minWalks = 0;
        // should always start from r0 c0;
        int[] start = {0,0};
        while(!q.isEmpty()){
            int[] polled = q.poll();
            //System.out.println(polled[0]+" "+polled[1]+" "+ polled[2]);
            int steps = minSteps(forest,start[0],start[1], polled[1],polled[2]);

            if(steps <0){
                return steps;
            }

            minWalks+=steps;

            // make the next start to the current target. to move to cut the next minHeight tree;
            start[0] = polled[1];
            start[1] = polled[2];
        }

        return minWalks;

    }

    public static int minSteps(List<List<Integer>> forest, int sr, int sc, int tr, int tc){
        // if source is the target min steps will be 0;
        if(sr == tr && sc == tc){
            return 0;
        }

        boolean[][] visited = new boolean[R][C];
        int minSteps = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        visited[sr][sc] = true;

        // BFS to find the target
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] polled = q.poll();
                if(polled[0] == tr && polled[1]==tc){
                    return minSteps;
                }

                for(int[] dir: directions){
                    int nr = polled[0]+dir[0], nc = polled[1]+dir[1];
                    if(nr<0 || nr>=R ||nc<0 ||nc>=C || visited[nr][nc] || forest.get(nr).get(nc) == 0){
                        continue;
                    }
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }
            }
            minSteps++;
        }

        return -1;
    }
}
