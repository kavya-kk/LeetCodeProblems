package leetcode.problems.Graph;

import java.util.*;

public class AlienAlphabets {

    public static void main(String[] str){
        String[] words = {"za","zb","ca","cb"};
        System.out.println("Finished "+ alienOrder(words));
    }

        public static String alienOrder(String[] words) {

            Map<Character,Integer> incomingCount = new HashMap<>();
            // get distinct chars in the
            for(String word: words){
                for(char c: word.toCharArray()){
                    //initially incomingCount is set to 0, while looking through words and once ordering is confirmed we can
                    //update this.
                    incomingCount.put(c,0);
                }
            }

            Map<Character, Set<Character>> edges = new HashMap<>();
            //Gathering the edges.
            for(int i=0;i<words.length-1;i++){
                //compare each word with the lexicographically next word to get the relative ordering of chars.
                String curWord = words[i];
                String nextWord = words[i+1];

                int minLen = Math.min(curWord.length(),nextWord.length());

                //compare chars at each position on both the words;
                for(int j=0;j<minLen;j++){
                    char cC = curWord.charAt(j);
                    char nC = nextWord.charAt(j);
                    //if two chars are same, continue to the next char
                    if(cC == nC){
                        continue;
                    }else {
                        // if the chars are inequal curWord's jth char is less than the nextWord's jth char
                        // this gives us the relative ordering;
                        if(!edges.containsKey(cC)){
                            edges.put(cC, new HashSet<>());
                        }
                        Set<Character> set = edges.get(cC);
                        if(!set.contains(nC)) {
                            set.add(nC);
                            incomingCount.put(nC, incomingCount.get(nC) + 1);
                        }
                        break;
                    }
                }
            }

            // if all chars have incoming edges, then there is a cycle. so ordering is not possible. so return empty string;
            String result = bfs(edges,incomingCount);
            if(result.length() == incomingCount.size()){
                return result;
            }
            return "";
        }

        public static String bfs(Map<Character, Set<Character>> edges, Map<Character,Integer> incomingCount){

            Queue<Character> queue = new LinkedList<>();

            //add all the chars whose ordering doesnt depend on any other char.
            for(Character c: incomingCount.keySet()){
                if(incomingCount.get(c) ==0){
                    queue.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()){
                int size = queue.size();

                for(int i =0;i<size;i++){
                    char curC = queue.poll();
                    sb.append(curC);
                    System.out.println(sb.toString());
                    Set<Character> neighbors = edges.get(curC);
                    if(neighbors == null || neighbors.isEmpty()){
                        // do nothing
                    }else {
                        for(char to: neighbors) {
                            incomingCount.put(to, incomingCount.get(to) - 1);
                            if (incomingCount.get(to) == 0) {
                                queue.add(to);
                            }
                        }
                    }
                }
            }
            return sb.toString();
        }
    }
