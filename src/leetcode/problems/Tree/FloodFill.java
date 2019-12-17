package leetcode.problems.Tree;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/flood-fill/
public class FloodFill {

    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args){
        int[][] image = {{1,1,0},{1,0,1},{1,1,0}};
        int[][] finalImage = floodFill(image,0,1,2);

        for(int i =0;i<finalImage.length;i++){
            System.out.println();
            for (int j=0;j<finalImage[0].length;j++){
                System.out.print(finalImage[i][j]+" ");
            }
        }

    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int R = image.length;

        // check if image is valid;
        if(R == 0 || image[0].length ==0){
            return image;
        }
        int C = image[0].length;
        // check if sr and sc are valid;
        if(sr<0 || sc<0 || sr>=R ||sc >=C){
            return image;
        }
        // to check if nei colors are same as that of org color of sr,sc;
        int srcColor = image[sr][sc];
        // to keep track of all visited points;
        boolean[][] visited = new boolean[R][C];
        // for BFS;
        Queue<int[]> queue = new LinkedList<>();

        //starting point
        queue.add(new int[]{sr,sc});
        visited[sr][sc] = true;

        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            image[polled[0]][polled[1]] = newColor;

            for(int[] dir : directions){
                int nr = dir[0]+polled[0];
                int nc = dir[1]+polled[1];
                if(nr<0 || nc<0 || nr>=R ||nc >=C ||visited[nr][nc] || image[nr][nc]!=srcColor){
                    continue;
                }
                queue.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }

        return image;
    }
}
