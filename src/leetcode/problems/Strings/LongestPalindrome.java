package leetcode.problems.Strings;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/longest-palindrome
public class LongestPalindrome {

    public static void main(String[] str) {
        String s = "aaaabbbccddeddd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        //get the count of each char in the string.
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int resultLen = 0;

        boolean isOddPresent = false;
        for (char c : charCount.keySet()) {
            int curCount = charCount.get(c);
            if (curCount % 2 == 0) {
                //include all the occurrences if the count is even.
                resultLen += curCount;
            } else {
                //include only even occurrences of the odd char.
                resultLen += curCount - 1;
                // update the flag to keep track there is a char that occurred odd number of times
                isOddPresent = true;
            }
        }

        // if atleast one char has occurred odd times, add one to the end result.
        if (isOddPresent) {
            resultLen += 1;
        }

        return resultLen;
    }
}
