package leetcode.problems.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://leetcode.com/problems/word-break/
public class WordBreak {
    public static void main(String[] str){
        String s = "catsanddog";
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("sand");
        dict.add("and");
        dict.add("dog");

        System.out.println(wordBreak(s,dict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;
        for(int i =1;i<=s.length();i++){
            for(int j = 0; j<i;j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length-1];
    }
}
