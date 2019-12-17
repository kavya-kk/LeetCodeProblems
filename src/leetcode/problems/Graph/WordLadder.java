package leetcode.problems.Graph;

import java.util.*;

public class WordLadder {
   static Map<Integer,List<Integer>> graph = new HashMap<>();
    public static void main(String[] str){
        String beginWord = "leet";
        String endWord = "code";
        String[] words = {"lest","leet","lose","lode","code"};
        System.out.println(ladderLength(beginWord,endWord,Arrays.asList(words)));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(wordList.size() == 0 || !wordList.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
        populateAdjacency(wordList);
        System.out.println( wordList);
        int minSteps =Integer.MAX_VALUE;
        for(int i =0;i<wordList.size();i++){

            String word = wordList.get(i);
            if(areConnected(beginWord,word)){
                int steps = minSteps(i,endWord, wordList);
                if(!word.equals(beginWord)){
                    steps++;
                }
                minSteps = Math.min(steps, minSteps);
            }
        }

        return minSteps == Integer.MAX_VALUE? 0 : minSteps;
    }

    private static int minSteps(int node,String endWord, List<String> wordList){
        boolean[] visited = new boolean[wordList.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] =true;
        int steps = 1;
        //level order traversal / BFS
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Integer polled = q.poll();
                // if endWord is reached;
                if(endWord.equals(wordList.get(polled))){
                    return steps;
                }

                List<Integer> neighbors = graph.get(polled);
                System.out.println("Neighbors of"+ wordList.get(polled)+" "+neighbors);
                // if polled has no neighbors;
                if(neighbors == null || neighbors.isEmpty()){
                    continue;
                }

                // if the neighbor is not visited add to the queue for BFS
                for(Integer nei: neighbors){
                    if(!visited[nei]){
                        q.add(nei);
                        visited[nei] = true;
                    }
                }
            }
            steps++;
        }
        return Integer.MAX_VALUE;
    }

    private static void populateAdjacency(List<String> wordList){
        int size = wordList.size();
        for(int i =0;i<size;i++){
            for(int j =i+1; j<size;j++){
                if(areConnected(wordList.get(i),wordList.get(j))){
                    if(!graph.containsKey(i)){
                        graph.put(i,new ArrayList<>());
                    }
                    graph.get(i).add(j);
                    if(!graph.containsKey(j)){
                        graph.put(j,new ArrayList<>());
                    }
                    graph.get(j).add(i);
                }
            }
        }
    }

    private static boolean areConnected(String n1, String n2){
        int count =0;
        for(int i =0;i<n1.length();i++){
            if(n1.charAt(i) != n2.charAt(i)){
                count++;
            }
        }
        if(count>1){
            return false;
        }
        return true;
    }
}
