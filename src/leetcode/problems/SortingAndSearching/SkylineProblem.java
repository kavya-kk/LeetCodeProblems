package leetcode.problems.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//https://www.youtube.com/watch?v=GSBLe8cKu0s&feature=youtu.be

//https://leetcode.com/problems/the-skyline-problem/
public class SkylineProblem {

    public static void main(String[] str) {
        int[][] buildings = {
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        };

        getSkyline(buildings);
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        if(buildings.length ==0){
            return result;
        }

        List<Integer[]> list = new ArrayList<>();
        getList(buildings, list);

        // store the elements in descending order.
        PriorityQueue<Integer> maxHeight = new PriorityQueue<>((a, b) -> b-a);
        int curMaxHeight = 0;
        maxHeight.add(0);

        for(Integer[] ele: list){
            // if it is a start element,
            if(ele[2] == 0){
                //add the curHeight to maxHeight queue.
                maxHeight.add(ele[1]);

                // if the curMaxHeight has been altered,
                if(curMaxHeight != maxHeight.peek()){
                    // change curMaxHeight to the new value;
                    curMaxHeight = maxHeight.peek();
                    // add the point to the result
                    int temp = curMaxHeight;
                    result.add(
                            new ArrayList<Integer>(){{
                                add(ele[0]);
                                add(temp);
                            }}
                    );
                }else {
                    // if the curMaxHeight is unchanged even after new point addition,
                    //  DO NOTHING.
                }

            }else {
                // if the element is an end element

                // remove the height from the queue.
                maxHeight.remove(ele[1]);
                // if the removal affected the curMaxHeight
                if(curMaxHeight != maxHeight.peek()){
                    // update the curMaxHeight
                    curMaxHeight = maxHeight.peek();
                    // add the cur point to the result
                    int temp = curMaxHeight;
                    result.add(
                            new ArrayList<Integer>(){{
                                add(ele[0]);
                                add(temp);
                            }}
                    );
                }else {
                    // do nothing.
                }
            }
        }

        return result;
    }

    private static void getList(int[][] buildings, List<Integer[]> list){

        for(int[] building: buildings){
            // for building (2,9,10) -> start = (2,10,0) & end =(9,10,1);
            // start (2,10,0) => 2-> art of the building, 10 -> height , 0 -> denotes it is the start.
            list.add(new Integer[]{building[0], building[2], 0});
            list.add(new Integer[]{building[1], building[2], 1});
        }

        //if start and end of two buildings are same, put the start first.
        list.sort((a,b) -> {
            int comp = a[0]-b[0];
            if(comp ==0){
                //the two buildings x's are same => the start point takes the priority
                if(a[2]!=b[2])
                    // if one point is start and one point is end; the start takes the priority;
                    return a[2]-b[2];
                else if(a[2] ==0){
                    // if both the points are starts the higher height should be seen first
                    return b[1] - a[1];
                }else if(a[2] == 1){
                    // if both the points are ends consider the lower height one first.
                    return a[1]- b[1];
                }
            }
            return comp;
        });
    }

}

