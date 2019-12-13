package leetcode.problems.Backtracking;

import java.util.Arrays;

public class RegexMatching {
    static Boolean[][] res;
    public static void main(String[] ar){
        String s = "aa";
        String p ="a";
        System.out.println(isMatch(s,p));
    }
    public static boolean isMatch(String str, String pattern) {
        res = new Boolean[str.length()+1][pattern.length()+1];
        for (Boolean[] a:
             res) {
            Arrays.fill(a,null);
        }
        return helper(str,pattern,0,0);
    }

    public static boolean helper(String str, String pattern, int sI, int pI){
        if(res[sI][pI] != null){
            return res[sI][pI];
        }
        //if all chars in pattern are matched
        if(pI == pattern.length()){
            // if all chars in string are also matched
            if(sI == str.length()) {
                res[sI][pI] = true;
                return true;
            } else {
                // if some chars in strings are yet to be matched then it is not a match.
                res[sI][pI] = false;
                return false;
            }
        }
        // if the chars at pI and sI are equal
        boolean cMatch = (sI <str.length())&& (str.charAt(sI) == pattern.charAt(pI) || pattern.charAt(pI) =='.');
        boolean temp = false;
        if(pI+1 <pattern.length() && pattern.charAt(pI+1) =='*'){
            temp =  helper(str,pattern,sI,pI+2) || (cMatch && helper(str,pattern,sI+1,pI));
        }else {
            temp =  cMatch && helper(str, pattern, sI+1, pI+1);
        }

        res[sI][pI] = temp;
        return temp;
    }
}
