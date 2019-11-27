package leetcode.problems.Strings;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] s){
        System.out.println(isValid("(){}[({})"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        int ind =0;
        while (ind!=s.length()){
            char c = s.charAt(ind);
            switch(c){
                case '{': case '[': case '(':
                    stk.push(c);
                    break;
                case '}': case ']': case ')':
                    if(stk.isEmpty()){
                        return false;
                    }else {
                        char cOpen = stk.pop();
                        switch(cOpen){
                            case '{':
                                if(c != '}' )
                                    return false;
                                break;
                            case '[':
                                if(c != ']' )
                                    return false;
                                break;
                            case '(':
                                if(c != ')' )
                                    return false;
                                break;

                        }
                    }
                    break;
            }
            ind++;
        }
        if(stk.isEmpty())
            return true;
        else
            return false;
    }
}
