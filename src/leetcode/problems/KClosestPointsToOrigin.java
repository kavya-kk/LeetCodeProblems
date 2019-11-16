package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] s){
        int[][] points =  {{-5,4},{-6,-5},{4,6}};
        int K = 2;
        for (int[] pt:
                kClosest(points,K) ) {
            System.out.println("("+pt[0]+","+pt[1]+")");
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> q = new PriorityQueue<>(K, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.dist > o2.dist){
                    return -1;
                }else if(o1.dist < o2.dist){
                    return 1;
                }
                return 0;
            }
        });

        for (int[] point:
                points) {
            Point newPoint = new Point(point[0],point[1]);
            if(q.size()<K){
                q.offer(newPoint);
            }else if(q.size() == K){
                Point pt = q.peek();
                if(newPoint.dist <pt.dist){
                    q.poll();
                    q.offer(newPoint);
                }
            }
        }
        int i =0;
        int[][] kClosest = new int[K][2];
        while(!q.isEmpty()) {
            Point ne = q.poll();
            int[] newPt = {ne.x,ne.y};
            kClosest[i++] = newPt ;
        }
        return kClosest;
    }

}

class Point {
    int x;
    int y ;
    double dist;
    Point (int x,int y){
        this.x = x;
        this.y = y;
        this.dist = Math.sqrt(x*x + y*y);
    }
}