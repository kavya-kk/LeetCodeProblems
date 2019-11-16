package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/prison-cells-after-n-days/
public class PrisonCells {
    public static void main(String[] qw){

        int[] cells = {0,1,0,1,1,0,0,1};
        for (int i: prisonAfterNDays(cells,7)) {
            System.out.print(i+",");
        }
    }
    public static int[] prisonAfterNDays(int[] c, int N) {
        Integer[] cells = Arrays.stream(c).boxed().toArray(Integer[]::new);
        List<List<Integer>>  combi = new ArrayList<>();
        while(combi.size() <= N){
            Integer[] newCells = new Integer[cells.length];
            for(int i =0;i<cells.length;i++){
                if(i==0 || i == cells.length-1){
                    newCells[i] = 0;
                }else {
                    newCells[i] = cells[i-1]== cells[i+1]? 1:0;
                }
            }
            if(combi.contains(Arrays.asList(newCells))){
                break;
            }
            combi.add(Arrays.asList(newCells));
            cells = newCells;

        }
        List<Integer> list = N%combi.size() == 0 ? combi.get(combi.size()-1): combi.get(N%combi.size()-1);

        return list.stream().mapToInt(i->i).toArray();
    }
}
