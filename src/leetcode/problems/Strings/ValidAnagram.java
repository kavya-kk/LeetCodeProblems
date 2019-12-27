package leetcode.problems.Strings;

//https://leetcode.com/problems/valid-anagram
public class ValidAnagram {
    public static void main(String[] swr){
        String string = "anagram";
        String s = "nagaram";
        System.out.println(isAnagram(string, s));
    }
    public static boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];
        // if their lengths are different then they are not anagrams
        if(s.length() != t.length()){
            return false;
        }

        for(char c: s.toCharArray()){
            charCount[c-'a']++;
        }

        for(char c: t.toCharArray()){
            charCount[c-'a']--;
            if(charCount[c-'a'] <0){
                return false;
            }
        }
        return true;
    }
}
