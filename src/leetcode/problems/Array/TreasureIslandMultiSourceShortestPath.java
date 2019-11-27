package leetcode.problems.Array;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/356150
public class TreasureIslandMultiSourceShortestPath {
    public static void main(String[] s){
        char[][] mat = {{'O', 'O', 'O', 'O', 'D'},
                        {'D', 'O', 'D', 'O', 'D'},
                        {'O', 'O', 'O', 'O', 'D'},
                        {'X', 'D', 'D', 'O', 'O'},
                        {'X', 'D', 'D', 'D', 'O'}};
        System.out.println(findTreasure(mat));
    }
    public static int findTreasure(char[][] mat){
        Queue<Coordinates> queue = new LinkedList<>();
        int rows = mat.length;
        int cols = mat[0].length;
        Coordinates[] directions = {
                new Coordinates(-1,0,0),//top
                new Coordinates(0,1,0),//right
                new Coordinates(1,0,0),//bottom
                new Coordinates(0,-1,0),//left
        };
        // push all sources to the queue;
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(mat[r][c] == 'S'){
                    queue.offer(new Coordinates(r,c,0));
                    mat[r][c] = 'D';
                }
            }
        }
        //Breadth first search
        while(!queue.isEmpty()){
            Coordinates cur = queue.poll();
            for (Coordinates dir:
                 directions) {
                int X = cur.x+dir.x;
                int Y = cur.y+dir.y;
                if(X < 0 || X>=rows || Y<0 || Y>=cols|| mat[X][Y] == 'D' ){
                    continue;
                }else if (mat[X][Y] == 'X'){
                    return cur.dist+1;
                }
                queue.offer(new Coordinates(X,Y,cur.dist+1));
                mat[X][Y] = 'D';
            }
        }
        return -1;
    }

    static class Coordinates {
        public int x;
        public int y;
        public int dist;
        public Coordinates(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinates that = (Coordinates) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
