package leetcode.problems.Strings;

import java.util.Stack;
//https://leetcode.com/problems/valid-parenthesis-string
public class ValidParanthesisString {

    public static void main(String[] str){
        String s =     "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        System.out.println(checkValidString(s));

    }

    public static boolean checkValidString(String s) {

        if(s.length() ==0){
            return true;
        }

        Stack<Integer> openStk = new Stack<>();
        Stack<Integer> starStk = new Stack<>();

        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur =='('){
                openStk.push(i);
            }else if (cur == ')'){
                if(openStk.isEmpty()){
                    if(starStk.size() >0){
                        starStk.pop();
                    }else {
                        return false;
                    }
                }else {
                    openStk.pop();
                }
            }else if (cur =='*'){
                starStk.push(i);
            }
        }
        if(openStk.isEmpty()){
            return true;
        }else if (openStk.size() <=starStk.size()){
            while(!openStk.isEmpty() && !starStk.isEmpty()){
                int open = openStk.pop();
                int star = starStk.pop();
                if(star > open){
                    continue;
                }else {
                    return false;
                }
            }
            if(openStk.isEmpty()){
                return true;
            }
        }
        return false;
    }
}
