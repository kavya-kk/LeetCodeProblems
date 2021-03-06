package leetcode.problems.General;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/most-common-word/
public class MostCommonWord {
    public static void main(String[] s){
        String para = "Bob. hIt, baLl";
        String[] banned = {"hit","bob"};
        System.out.println(mostCommonWord(para,banned));
    }
    private static String mostCommonWord (String paragraph , String[] banned){
        int maxCount = 0;
        String word = "";
        String para = paragraph.replaceAll("[,\\.;?!']"," ").toLowerCase();
        List<String> bannedL = Arrays.asList(banned);
        Map<String,Integer> wordCount = new HashMap<>();
        for (String clean:
                para.split(" ")) {
            if(clean.equals("")){
                continue;
            }
            wordCount.put(clean,wordCount.getOrDefault(clean,0)+1);
            int count = wordCount.get(clean);
            if(maxCount<count && !bannedL.contains(clean)){
                maxCount = count;
                word = clean;
            }
        }
        return word;
    }
}
