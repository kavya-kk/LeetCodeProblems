package leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PartitionLabels {
    public static void main(String[] qwe){
        String s = "abbcbcdefegdhijhklij";
        for (int i:
             partitionLabels(s)) {
            System.out.println(i);
        }
    }


    public static  List<Integer> partitionLabels(String s) {
        Set<Character> set = new HashSet<>();
        List<Integer> partitionLabels = new LinkedList<>();
        int curS = -1;
        int curE = -1;
        for(int i = 0 ;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                if(curS <0){
                    curS = i;
                }
                int lastIdx = s.lastIndexOf(s.charAt(i));
                curE = Math.max(curE , lastIdx );
                set.add(s.charAt(i));
            }
            if(i == curE){
                partitionLabels.add(curE-curS+1);
                curS = -1;
                curE = -1;
            }
        }
        return partitionLabels;
    }
}

class CharacterProp {
    int start;
    int end;
    int count;
    CharacterProp(int start, int end, int count){
        this.start = start;
        this.end = end;
        this.count = count;
    }
}
