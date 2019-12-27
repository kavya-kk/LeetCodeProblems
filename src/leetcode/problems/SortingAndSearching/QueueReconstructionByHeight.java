package leetcode.problems.SortingAndSearching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/queue-reconstruction-by-height/
public class QueueReconstructionByHeight {

    public static void main(String[] str) {
        int[][] people = {{1,0},{2,0},{3,0},{4,0}};
        int[][] ordered = reconstructQueue(people);

        for(int[] ele: ordered){
            System.out.println(ele[0]+","+ele[1]);
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        if(people.length == 0 || people[0].length ==0){
            return people;
        }
        // sort people by height in descending order, if their heights are same order by the ascending order of the position;
        Arrays.sort(people, (a, b) -> {
            int comp = b[0]-a[0];
            if(comp == 0){
                return a[1] - b[1];
            }
            return comp;
        });

        List<int[]> list = new LinkedList<>();
        for(int[] element: people){
            list.add(element[1],element);
        }

        return list.toArray(new int[people.length][2]);
    }
}
