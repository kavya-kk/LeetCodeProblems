package leetcode.problems;

public class LongestCommonPrefix {

    public static void main(String[] str){
        String[] strs = {"","dog","dead"};
        System.out.println(longestCommonPrefix(strs));
    }
    private static String longestCommonPrefix(String[] strs) {
        String pref = strs[0];
        for (int i =1; i< strs.length; i++){
            while(strs[i].indexOf(pref) != 0){
                pref = pref.substring(0,pref.length()-1);
            }
        }
        return pref;
    }
}
