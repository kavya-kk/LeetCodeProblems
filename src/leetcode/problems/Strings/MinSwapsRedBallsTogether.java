package leetcode.problems.Strings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/discuss/interview-question/414660/
public class MinSwapsRedBallsTogether {
    public static void main(String[] s324){
        String s = "WRRWWR";
        System.out.println(minSwaps(s));
    }

    private static int minSwaps(String s){
        List<Integer> list = getRedIndices(s);
        int midOfList = list.size()/2;
        int minSwaps =0;
        for(int i=0;i<list.size();i++){
            //no of swaps required to move R at list(i) position next to list(mid)
            int numSwaps = Math.abs(list.get(midOfList) - list.get(i));
            //no of R in between i and mid
            int numOfRed = Math.abs(midOfList-i);

            // no. of swaps required to move the R at ith position, next to middle R is ==> no of swaps required - number of reds in between
            minSwaps+= (numSwaps-numOfRed);
        }
        return minSwaps;
    }
    private static List<Integer> getRedIndices(String s){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'R'){
                list.add(i);
            }
        }
        return list;
    }
}
