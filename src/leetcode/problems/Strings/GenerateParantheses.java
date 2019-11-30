package leetcode.problems.Strings;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/generate-parentheses/
public class GenerateParantheses {
    public static void main(String[] s){
        Solution sol = new Solution();
        List<String> solution  = sol.generateParanthesis(4);
        for (String st:
             solution) {
            System.out.print(st + "   ");
        }
    }

    static class Solution {
        public List<String> generateParanthesis(int n){
            List<String> result = new ArrayList<String>();
            generateOneByOne("",result,0,0,n) ;
            return result;
        }

        private void generateOneByOne(String str, List<String> list, int open, int close, int n){
            if(str.length() == n*2){
                list.add(str);
                return;
            }

            if(open<n){
                generateOneByOne(str+"(", list, open+1, close, n);
            }
            if(close <open){
                generateOneByOne(str+")", list, open, close+1, n);
            }
        }
    }
}


