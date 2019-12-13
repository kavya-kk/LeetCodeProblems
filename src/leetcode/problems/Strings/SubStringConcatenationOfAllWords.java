package leetcode.problems.Strings;

import java.util.*;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words/
public class SubStringConcatenationOfAllWords {
    public static void main(String[] s){
        String str = "barfoothefoobarman";

        String[] words = {"foo","bar"};
        List<Integer> indices = subStringConcat(str,words);
        System.out.println(Arrays.toString(indices.toArray()));
    }
    private static List<Integer> subStringConcat(String str, String[] wds){
        List<Integer> indices = new ArrayList<>();
        if(wds.length == 0){
            return indices;
        }

        List<String> words = Arrays.asList(wds);
        int len = words.get(0).length();
        int concLen = len*words.size();
        if(str.length() < (concLen)){
            return indices;
        }

        Window w = new Window(words);
        for(int left = 0;left < str.length(); left++){
            int right = left+concLen;
            if(right >str.length()){
                break;
            }
            String concString = str.substring(left,right);
            for(int i = 0; (i+len)<=concString.length(); i+=len){
                String sub = concString.substring(i,i+len);
                if(words.contains(sub)){
                    if(!w.add(sub)){
                        w.emptyWindow();
                        break;
                    }
                }else {
                    w.emptyWindow();
                    break;
                }
            }
            if(w.size() == words.size()){
                indices.add(left);
                w.emptyWindow();
            }
        }
        return indices;
    }
}

 class Window{
    private Map<String,Integer> words;
    private Map<String,Integer> wordCount;
    private int size = 0;
    public Window(List<String> wordList){
        words = new HashMap<>();
        wordCount = new HashMap<>();
        for(String s: wordList){
            int count = wordCount.getOrDefault(s,0);
            wordCount.put(s,++count);
        }
    }
    public boolean add(String word){
        int cnt = words.getOrDefault(word,0);
        if(cnt < wordCount.get(word)){
            words.put(word,++cnt);
            size++;
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void emptyWindow(){
        words = new HashMap<>();
        size = 0;
    }
}
