package leetcode.problems;

import java.util.HashSet;

//https://leetcode.com/discuss/interview-question/351783/
public class MinSwapsForPalindrome {

    public static void main(String[] po){
        String pal = "aabab";

        System.out.println(minSwaps(pal));
    }

    private static int minSwaps(String s){
        char[] sArr = s.toCharArray();
        int minSwaps = 0;
        if(!isPalPossible(s)){
            return -1;
        }else {
            int i =0, j = sArr.length-1;
            int k=j;
            while(i<j){
                k=j;
                while(sArr[i] != sArr[k]&& i<k){
                    k--;
                }
                if(sArr[i] == sArr[k] && i!=k){
                    while(k!=j){
                        swapChars(sArr,k,k+1);
                        k++;
                        minSwaps++;
                    }
                    i++;
                    j--;
                }else {
                    swapChars(sArr,i,i+1);
                    minSwaps++;
                }
            }
        }
        return minSwaps;
    }

    private static void swapChars(char[] s, int i, int j){
        char iChar = s[i];
        s[i] = s[j];
        s[j] = iChar;
    }
    
    private static boolean isPalPossible(String s){
        int uniq = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i =0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                uniq++;
            }
            set.add(s.charAt(i));
        }
        return s.length()%2 == 0 ? uniq <= s.length()/2 : uniq <= (s.length()/2)+1;
    }
}
