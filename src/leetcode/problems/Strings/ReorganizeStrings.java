package leetcode.problems.Strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/distant-barcodes/
//https://leetcode.com/problems/reorganize-string
public class ReorganizeStrings {

    public static void main(String[] s) {
        String input = "aabbccc";
        System.out.println("Output is " + reOrganize(input));
    }

    private static String reOrganize(String input) {
        char[] output = new char[input.length()];
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            charCount.put(input.charAt(i), charCount.getOrDefault(input.charAt(i), 0) + 1);
        }

        PriorityQueue<LetterCount> letters = new PriorityQueue<>(new Comparator<LetterCount>() {
            @Override
            public int compare(LetterCount o1, LetterCount o2) {
                if (o1.count < o2.count) {
                    return 1;
                } else if (o1.count > o2.count) {
                    return -1;
                }
                return 0;
            }
        });
        for (char c :
                charCount.keySet()) {
            letters.offer(new LetterCount(c, charCount.get(c)));
        }

        int index = 1;
        int i =0;
        LetterCount max = letters.poll();
        while(max.count>0){
            output[i] = max.letter;
            i+=2;
            max.count-=1;
            if(i>=output.length && max.count !=0){
                return "";
            }
        }

        while(!letters.isEmpty()){
            max = letters.poll();
            while(max.count>0){
                if(i < output.length){
                    output[i] = max.letter;
                    i+=2;
                    max.count-=1;
                }else {
                    i=index;
                }
            }
        }
        String outputStr = "";
        for(char c: output){
            outputStr+=c;
        }
        return outputStr;
    }


    static class LetterCount {
        char letter;
        int count;
        LetterCount (char letter, int count){
            this.letter = letter;
            this.count = count;
        }

        @Override
        public String toString() {
            return "LetterCount{" +
                    "letter=" + letter +
                    ", count=" + count +
                    '}';
        }
    }
}
