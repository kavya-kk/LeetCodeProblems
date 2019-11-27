package leetcode.problems.Array;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] s){
        String[] str = {"ate","eat","tea","nat","tan","bat"};
        List<List<String>> hi = groupAnagrams(str);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();
        for (String s:
             strs) {
            String key =getKey(s);
            if(groups.containsKey(key)){
                List<String> list = groups.get(key);
                list.add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                groups.put(key,list);
            }
        }
        List<List<String>> anagrams = new ArrayList<List<String>>();
            anagrams.addAll(groups.values());
        return anagrams;
    }

    private static String getKey(String s){
        char[] cArray = s.toCharArray();
        Arrays.sort(cArray);
        return String.valueOf(cArray);
    }
}
