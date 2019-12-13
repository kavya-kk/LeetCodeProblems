package leetcode.problems.Strings;

public class IsValidPalindrome {
    public static void main(String[] arg){
        System.out.println(isPalindrome(".,.,.23"));
    }
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            // skip start to alphanumeric
            if (!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))) {
                start++;
                continue;
            }
            // skip end to alphanumeric
            if (!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))) {
                end--;
                continue;
            }


            // get startChar and endChar if alphabetic convert them to lowercase for comparison convenience
            char sChar = Character.isAlphabetic(s.charAt(start)) ? Character.toLowerCase(s.charAt(start)) : s.charAt(start);
            char eChar = Character.isAlphabetic(s.charAt(end)) ? Character.toLowerCase(s.charAt(end)) : s.charAt(end);

            // if equal we can proceed validating next chars
            if (sChar == eChar) {
                start++;
                end--;
            } else {
                // if not the string is not a palindrome
                return false;
            }
        }
        // if start is still lesser than end and two characters are not equal
        if (start < end && s.charAt(start) != s.charAt(end))
            return false;
        return true;
    }
}
