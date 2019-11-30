package leetcode.problems.Strings;

//https://leetcode.com/discuss/interview-question/398037/
public class LongestSemiAlternatingSubstring {
    public static void main(String[] s){
        String input = "bbaabbaa";
        System.out.println(longestSemiAlternating(input));
    }
    private static int longestSemiAlternating(String input){
        int maxLength = 0;
        int start =0;
        for(int i =0;i<input.length();){
            if(i+1 <input.length() && input.charAt(i) != input.charAt(i+1)){
                i++;
                continue;
            }

            int j = i+1;
            while(j<input.length() && input.charAt(i) == input.charAt(j)){
                j++;
            }
            if(j-i>2 || j >= input.length()) {
                if(i==input.length()-1){
                    i--;
                }
                int length = (i + 1) - start + 1;
                maxLength = Math.max(length, maxLength);
                start = j-2;
            }
            i = j;

        }
        return maxLength;
    }
}
