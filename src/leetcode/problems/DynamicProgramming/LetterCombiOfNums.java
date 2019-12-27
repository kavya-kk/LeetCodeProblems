package leetcode.problems.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//BACKTRACKING
//https://leetcode.com/problems/letter-combinations-of-a-phone-number
public class LetterCombiOfNums {

    static Map<String,String> map = new HashMap<String,String>();
    static List<String> combinations = new ArrayList<>();
       public static void main(String[] s){
        letterCombinations("23");

        System.out.println(combinations);
    }

    public static List<String> letterCombinations(String digits) {
        init();
        if(digits.length() == 0){
            return combinations;
        }
        helper("",digits);
        return combinations;
    }

    private static void helper(String cur, String digits){
        if(digits.length() ==0){
            combinations.add(cur);
            return ;
        }
        String digit = digits.substring(0,1);
        String letters = map.get(digit);
        for(int i =0;i<letters.length();i++){
            helper(cur+letters.charAt(i),digits.substring(1));
        }
    }

    private static void init(){
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }
}

