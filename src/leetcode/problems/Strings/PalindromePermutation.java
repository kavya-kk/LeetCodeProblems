package leetcode.problems.Strings;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/palindrome-permutation/
public class PalindromePermutation {
    public static void main(String[] str){
        String s = "abaa";
        System.out.println(canPermutePalindrome(s));
    }

    public static boolean canPermutePalindrome(String s) {
        Map<Character,Integer> charCount = new HashMap<>();
        for(char c: s.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c,0)+1);
        }

        int len = s.length();
        int oddCount = 0;
        for(Character i: charCount.keySet()){
            if(charCount.get(i)%2 == 1){
                oddCount++;
            }
        }

        //aabaa len =5 oddC = 1  true
        //abc len 3 oddCount =3 false
        //abcb len 4 oddCount =2 false
        //aabbaa len 6 oddCount =0 true
        if((len%2 ==1 && oddCount >1) || (len%2 ==0 && oddCount >0)){
            return false;
        }
        return true;
    }
}
