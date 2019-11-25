package leetcode.problems;

import java.util.Arrays;

//https://leetcode.com/discuss/interview-question/364618/
public class MinStepsForEqualHeightPiles {

    public static void main(String[] s){
        Integer[] piles = {4,5,3,5,1,1,1,2};
        System.out.println(minSteps(piles));
    }

    private static int minSteps(Integer[] piles){
        int steps = 0;
        Arrays.sort(piles,(a,b)-> b-a);
        for(int i =1;i<piles.length; i++){
            steps += piles[i]< piles[i-1]? i : 0;
        }
        return steps;
    }
}
