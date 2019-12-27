package leetcode.problems.Recursion;

import java.util.*;
//GOOGLE
//https://leetcode.com/problems/word-squares/
public class WordSquare {

    static Map<String, Set<String>> prefixMap = new HashMap<>();
    static List<List<String>> result = new ArrayList<>();
    public static void main(String[] str){
        String[] words = {"ball","wall","lead","lady","area"};
        List<List<String>> wordSquares = wordSquares(words);
        for(List<String> list : wordSquares){
            System.out.println(list);
        }
    }

        public static List<List<String>> wordSquares(String[] words) {
            init(words);

            for(String word: words){
                List<String> wordSquare = new ArrayList<>();
                wordSquare.add(word);
                helper(1,wordSquare);
            }
            return result;
        }

        private static void helper(int curIdx, List<String> wordSquare){
            if(wordSquare.size() == wordSquare.get(0).length()){
                result.add(wordSquare);
                return;
            }

            String curPrefix = "";
            for(String word: wordSquare){
                curPrefix += word.charAt(curIdx)+"";
            }

            Set<String> prefixStrings = prefixMap.get(curPrefix);
            if(prefixStrings == null || prefixStrings.isEmpty()){
                return;
            }

            for(String prefixStr: prefixStrings){
                List<String> next = new ArrayList<>(wordSquare);
                next.add(prefixStr);
                helper(curIdx+1, next);
            }

        }


        private static void init(String[] words){
            prefixMap = new HashMap<>();
            result = new ArrayList<>();
            int wordLen = words[0].length();
            // for each word add the word and its all possible prefixes to the prefixMap
            for(String word: words){
                for(int i =0;i<wordLen;i++){
                    String prefix = word.substring(0,i+1);

                    if(!prefixMap.containsKey(prefix)){
                        prefixMap.put(prefix,new HashSet<>());
                    }
                    prefixMap.get(prefix).add(word);
                }
            }
        }

    }

