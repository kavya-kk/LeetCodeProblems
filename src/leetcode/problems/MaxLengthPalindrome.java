package leetcode.problems;

//https://leetcode.com/problems/longest-palindromic-substring/
public class MaxLengthPalindrome     {
    public static void main(String[] st){
        String s = "maala";
        System.out.println(maxLengthPal(s));
    }

    private static String maxLengthPal(String s){
        int startIndex=0, maxLength = 0;
        boolean[][] palOrNot = new boolean[s.length()][s.length()];
        for (int i =s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                palOrNot[i][j] = s.charAt(i)== s.charAt(j) && (j-i<3 || palOrNot[i+1][j-1]);

                if(palOrNot[i][j] && j-i+1 >maxLength){
                    maxLength = j-i+1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex,startIndex+maxLength);
    }
}
