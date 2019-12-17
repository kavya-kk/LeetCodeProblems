package leetcode.problems.Strings;

//https://leetcode.com/problems/implement-strstr/
public class HaystackNeedle {
    public static void main(String[] art){
        String string = "bbababaaaababbaabbbabbbaaabbbaaababbabaabbaaaaabbaaabbbbaaabaabbaababbbaabaaababbaaabbbbbbaabbbbbaaabbababaaaaabaabbbababbaababaabbaa";
        String s = "bbabba";
        Solution sol =  new Solution();
        System.out.println(sol.strStr(string,s));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        int[] prefixArr = new int[needle.length()];
        findPrefixArr(needle,prefixArr);

        int hI = 0, nI =0;
        int startIdx = -1;

        while(nI < prefixArr.length && hI < haystack.length()){
            if(haystack.charAt(hI) == needle.charAt(nI)){
                if(startIdx ==-1){
                    startIdx = hI;
                }
                hI++;
                nI++;
            }else {

                //if there is a possibility to check if suffix is a prefix.
                if(nI>0){
                    nI = prefixArr[nI-1];
                }
                if(haystack.charAt(hI) == needle.charAt(nI)){

                    startIdx = hI-nI;

                    continue;
                }else {
                    startIdx=-1;
                    nI=0;
                    hI++;
                }
            }
        }
        if(nI < prefixArr.length){
            startIdx =-1;
        }
        return startIdx;
    }

    private void findPrefixArr(String s, int[] prefixArr){
        int j=0, i=1;
        prefixArr[j]=0;
        while(i<s.length()){
            if(s.charAt(j) == s.charAt(i)){
                prefixArr[i] = j+1;
                j++;
            }else {
                prefixArr[i]=prefixArr[i-1];
            }
            i++;
        }
    }
}