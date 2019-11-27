package leetcode.problems.Array;

import java.util.HashMap;

//https://leetcode.com/discuss/interview-question/331158
public class RollDice {
    static HashMap<Integer,Integer> pairs = new HashMap<>();
    public static void main(String[] str){
        int[] a = {6,6,6,6,6};
        System.out.println(minTurns(a));
    }

    private static int minTurns(int[] a){
        init();
        int minCost = Integer.MAX_VALUE;

        // find cost to flip to each number in the dice and minimise the minCost
        for(int i=1;i<=6;i++){
            int cost = 0;
            for (int side: a) {
                cost += (i==side) ? 0 : ((i == pairs.get(side)) ? 2 :1);
            }
            minCost = Math.min(cost, minCost);
            if(minCost == 0){
                break;
            }
        }
        return minCost;
    }

    private static void init(){
        for(int i=1;i<=6;i++){
            pairs.put(i,7-i);
        }
    }
}
