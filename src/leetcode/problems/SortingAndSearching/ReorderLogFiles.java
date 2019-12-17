package leetcode.problems.SortingAndSearching;

import java.util.Arrays;
//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderLogFiles {
    public static void main(String[] s){
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        reorderLogFiles(logs);
        for (String log:
                logs) {
            System.out.println(log);
        }
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(log1,log2) -> {
            String[] s1 = log1.split(" ",2);
            String[] s2 = log2.split(" ",2);

            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                int comp = s1[1].compareTo(s2[1]);
                if(comp != 0){
                    return comp;
                }
                return s1[0].compareTo(s2[0]);
            }else {
                return isDigit1 ? (isDigit2 ? 0 :1):-1;
            }
        });
        return logs;
    }

}


