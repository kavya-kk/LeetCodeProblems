package leetcode.problems.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchII {
    public static void main(String[] s){
        Solution sol = new Solution();
        char[][] board ={ {'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}};
        String[] a = {"oaaneateihkrvlfi"};
        System.out.println(sol.findWords(board, a));
    }
}

class Solution {

    List<String> result = new ArrayList<>();
    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        if(words.length == 0 || board.length ==0 || board[0].length == 0){
            return result;
        }
        // Add each word to trie.
        for(String word: words){
            root.insert(word);
        }

        // for each character in the board check if it is in the trie
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(root.children.containsKey(board[r][c])){
                    helper(board,r,c,root);
                }
            }
        }
        return result;
    }

    public void helper(char[][] board, int R, int C, TrieNode root){
        TrieNode curRoot = root.children.get(board[R][C]);
        if(curRoot.word !=""){
            result.add(curRoot.word);
            curRoot.word = "";
        }
        int[][] neiDirs = {{0,1},{0,-1},{1,0},{-1,0}};
        char curChar = board[R][C];
        board[R][C] = '#';
        for(int[] dir: neiDirs){
            int nR = R+dir[0];
            int nC = C+dir[1];

            if(nR>=0 && nR< board.length && nC >=0 && nC < board[0].length && board[nR][nC]!= '#'){
                if(curRoot.children.containsKey(board[nR][nC])){
                    helper(board,nR,nC,curRoot);
                }
            }

        }
        board[R][C] = curChar;
    }
}

class TrieNode{
    char val = ' ';
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = "";

    public TrieNode(char val , HashMap<Character, TrieNode> children ){
        this.val = val;
        this.children = children;
    }
    public TrieNode(){

    }

    public void insert(String word){
        if(word.length() ==0){
            return ;
        }
        int i =0;
        TrieNode tRoot = this;
        HashMap<Character,TrieNode> words;
        while(i<word.length()){
            words = tRoot.children;
            char curChar = word.charAt(i);
            if(!words.containsKey(curChar)){
                words.put(curChar,new TrieNode(curChar,new HashMap<>()));
            }
            i++;
            tRoot = words.get(curChar);
        }
        tRoot.word = word;
    }
}