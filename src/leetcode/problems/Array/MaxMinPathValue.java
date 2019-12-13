package leetcode.problems.Array;

import java.util.PriorityQueue;

//https://leetcode.com/problems/path-with-maximum-minimum-value/
public class MaxMinPathValue {
    public static void main(String[] s){
        int[][] A = {{5,4,5},
                {1,2,6},
                {7,4,6}};
        System.out.println(maxMinPathValue(A));
    }

    public static int maxMinPathValue(int[][] A){
        int R = A.length;
        if(R==0 || A[0].length == 0){
            return -1;
        }
        int C = A[0].length;
        int[][] directions  = {{0,1},{0,-1},{1,0},{-1,0}};
        // pq stores int array of size 3. idx 0 - the value, idx 1 - row id, idx 2 - col id;
        // the order of storages id desc based on the 0th idx;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int res = A[0][0];
        A[0][0] = -1;// to mark it visited;
        pq.add(new int[] {res,0,0});
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int r = top[1], c = top[2];
            res = Math.min(top[0],res);
            if(r == R-1 && c == C-1){
                return res;
            }
            for(int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < R && newC >= 0 && newC < C && A[newR][newC] >= 0) {
                    pq.add(new int[]{A[newR][newC], newR, newC});
                    A[newR][newC] = -1;
                }
            }
        }
        return -1;
    }
}
