package leetcode.problems.General;

import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                boolean isDigit1 = s1.matches(".*\\s[0-9].*");
                boolean isDigit2 = s2.matches(".*\\s[0-9].*");

                if(isDigit1 && isDigit2){
                    // leave the natural ordering.
                    return 0;
                }else if (isDigit1 && !isDigit2){
                    // s2 is first
                    return 1;
                }else if (!isDigit1 && isDigit2) {
                    // s1 is first
                    return -1;
                }else {
                    String[] log1 = s1.split(" ",2);
                    String[] log2 = s2.split(" ",2);
                    if(log1[0].compareTo(log2[0])==0){
                        // if 2 ids are same, lexicogra. order the rest.
                        return log1[0].compareTo(log2[0]);
                    }else {
                        return log1[1].substring(1).compareTo(log2[1].substring(1));
                    }
                }
            }
        });

        return logs;
    }
}


