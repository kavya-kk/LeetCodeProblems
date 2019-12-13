package leetcode.problems.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationOfLettersInAString {

    public static void main(String[] arg){
        String str = "abc";
        List<String> permutations = getPermutations(str);
        System.out.println(permutations);
    }


    private static List<String> getPermutations(String str){
        List<String> perms = new ArrayList<>();
        if(str.length()==0){
            return perms;
        }
        //gather the number of occurrences of each char in the string
        Map<Character,Integer> charCount = getCharCount(str);
        int countArr[] = new int[charCount.keySet().size()];
        char charArr[] = new char[countArr.length];
        int i =0;
        for (char c: charCount.keySet()) {
            countArr[i] = charCount.get(c);
            charArr[i] = c;
            i++;
        }
        // invoke the helper to generate permutations.
        helper(charArr,countArr,perms, 0,new char[str.length()]);
        return perms;
    }

    private static void helper(char[] charArr,int[] countArr, List<String> perms, int level,char[] res){
        if(level == res.length){
            perms.add(String.valueOf(res));
            return;
        }
        for(int i =0;i<countArr.length; i++){
            if(countArr[i] >0) {
                res[level] = charArr[i];
                countArr[i]--;
                helper(charArr, countArr, perms, level + 1, res);
                countArr[i]++;
            }
        }
    }

    private static Map<Character,Integer> getCharCount(String str){
        Map<Character,Integer> map = new HashMap<>();
        for (char c:
             str.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        return map;
    }

}
