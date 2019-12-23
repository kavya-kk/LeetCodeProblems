package leetcode.problems.Graph;

import java.util.*;

//https://leetcode.com/discuss/interview-question/347457
public class TreasureIsland {
    public static void main(String[] s){
        char[][] mat = {{'O', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'O'},
                {'O', 'D', 'O', 'O'},
                {'O', 'D', 'D', 'O'}};
        System.out.println(findTreasure(mat));
    }

    public static int findTreasure(char[][] mat){
        List<Coordinates> visitedCoords = new ArrayList<>();
        Queue<Coordinates> q = new LinkedList<>();
        Coordinates cur ;
        q.offer(new Coordinates(0,0,0));
        Coordinates[] directions = {
                new Coordinates(-1,0,0),//top
                new Coordinates(0,1,0),//right
                new Coordinates(1,0,0),//bottom
                new Coordinates(0,-1,0),//left
        };

        while(!q.isEmpty()){
            cur = q.poll();
            if(!visitedCoords.contains(cur)){
                visitedCoords.add(cur);
                for (Coordinates dir:
                    directions ) {
                    // move into all directions and add the points
                    // new point coordinates
                    int newX = cur.x+dir.x;
                    int newY = cur.y+dir.y;
                    // if position is valid
                    if(newX<0 || newX >= mat.length || newY <0 || newY >=mat[0].length){
                        continue;
                    }
                    // position value
                    char dirPosVal = mat[newX][newY];
                    // if already visited or has dangerous value ignore
                    if(dirPosVal =='D' ||
                            visitedCoords.contains(new Coordinates(newX,newY,0))){
                        continue;
                    }
                    // if treasure is found return distance
                    else if (dirPosVal =='X'){
                        return cur.dist+1;
                    }
                    // in case move is possible add it to queue.
                    q.offer(new Coordinates(newX,newY,cur.dist+1));
                }
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

