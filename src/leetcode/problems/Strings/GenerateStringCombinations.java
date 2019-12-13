package leetcode.problems.Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateStringCombinations {

    public static void main(String[] arg){
        String str = "aacd";

        System.out.println(generateCombinations(str).size());
    }

    private static List<String> generateCombinations(String str){
        List<String> combinations = new ArrayList<>();

        if(str.length() == 0){
            return combinations;
        }

        helper(str,0,"",combinations);

        return combinations;
    }

    private static void helper(String s, int curPtr, String curString, List<String> combinations){
        if(curString.length()<=s.length()){
            combinations.add(curString);
        }

        for(int i =curPtr; i<s.length();i++){
            helper(s,i+1,curString+s.charAt(i),combinations);
        }
    }
}
