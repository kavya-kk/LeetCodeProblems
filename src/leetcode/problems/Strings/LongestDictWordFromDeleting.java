package leetcode.problems.Strings;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
public class LongestDictWordFromDeleting {
    public static void main(String[] str){
        String s = "abcpdplea";
        String[] d ={"apple","monkey","money","plea"};
        System.out.println(findLongestWord(s,Arrays.asList(d)));
    }
    public static String findLongestWord(String s, List<String> d) {
        String result ="";
        for(String dictWord: d){
            if(s.length()>=dictWord.length()){
                // check if the dictword can be formed. If yes check if its length is greater than the previously calculated result.
                if(helper(s,dictWord)){
                    // if prevResult's length is lesser or
                    // prevResult.len == dictWord.len then consider the lexicographically smaller string;
                    if(result.length()< dictWord.length() || (result.length() == dictWord.length() && result.compareTo(dictWord) > 0)){
                        result = dictWord;
                    }
                }
            }
        }
        return result;
    }

    private static boolean helper(String str, String word){

        int sI = 0, wI = 0;
        while(sI <str.length() && wI< word.length()){
            if(str.charAt(sI) == word.charAt(wI)){
                wI++;
            }
            sI++;
        }

        return wI == word.length();
    }
}
