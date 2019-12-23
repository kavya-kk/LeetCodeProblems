package leetcode.problems.Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinWindowSubString {

   static Map<Character,Integer> windowChars;
    static Queue<Integer> queue;
    static Map<Character,Integer> tChars;
    static int minLen = Integer.MAX_VALUE;
    static String resultString ="";
    static int uniqCount =0;

    public static void main(String[] str) {
        String string =  minWindow("adobecodebancbbca","abc");
        System.out.println(string);
    }


    public static String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();;
        if(sLen < tLen){
            return resultString;
        }
        // get the necessary chars and their count from t;

        tChars = new HashMap<>();
        for(int i =0;i<tLen;i++){
            tChars.put(t.charAt(i),tChars.getOrDefault(t.charAt(i),0)+1);
        }

        // Window def
        windowChars = new HashMap<>();
        queue = new LinkedList<>();

        // start traversing s char by char.
        for(int i=0;i<sLen;i++){
            char c = s.charAt(i);

            // if the char is significant process it
            if(tChars.containsKey(c)){
                int tCount = tChars.get(c);
                int winCount = windowChars.getOrDefault(c,0);
                windowChars.put(c,++winCount);
                // if adding the cur char makes the count equal to the count of it in t then inc the uniqCount
                if(winCount == tCount){
                    uniqCount++;
                }else if(!queue.isEmpty() && c == s.charAt(queue.peek()) && winCount > tCount){
                    slideWindow(s);
                }
                queue.add(i);
            }else {
                // do nothing and move the next char
            }

            //after processing the char, if the window has all the chars with equal counts required by tChars, process the window to the the substring;
            if(uniqCount == tChars.size()){
                int start = queue.peek();
                int end = i;
                if(minLen > end-start+1){
                    minLen = end-start+1;
                    resultString = s.substring(start,end+1);
                }
                //slide the window.
                slideWindow(s);
            }
        }
        return resultString;
    }

    public static void slideWindow(String s){
        //remove the first position in queue since it has already been processed or since it is being covered at the end;
        int polled = queue.poll();
        char polledChar = s.charAt(polled);

        int polledCount = windowChars.get(polledChar);
        windowChars.put(polledChar,--polledCount);
        int tCount = tChars.get(polledChar);

        if(polledCount <tCount){
            uniqCount--;
        }

        // remove duplicate chars of more than required count from top of the window.
        while(!queue.isEmpty() && windowChars.get(s.charAt(queue.peek())) > tChars.get(s.charAt(queue.peek()))){
            int cur = queue.poll();
            windowChars.put(s.charAt(cur), windowChars.get(s.charAt(cur))-1);
        }

    }
}
