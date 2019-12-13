package leetcode.problems.DesignQuestions;

import java.util.HashMap;

public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode(' ', new HashMap<>());
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.length() == 0){
            return;
        }
        TrieNode tRoot = this.root;
        HashMap<Character, TrieNode> words;
        int i =0;
        while(i<word.length()){
            words = tRoot.children;
            char c = word.charAt(i);
            if(!words.containsKey(c)){
                words.put(c,new TrieNode(c,new HashMap<>()));
            }
            tRoot = words.get(c);
            i++;
        }
        tRoot.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length() == 0){
            return false;
        }
        TrieNode tRoot= this.root;
        HashMap<Character, TrieNode>  words;
        int i =0;
        while(i<word.length()){
            words = tRoot.children;
            char c = word.charAt(i);
            if(!words.containsKey(c)){
                return false;
            }
            tRoot = words.get(c);
            i++;
        }
        return tRoot.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0){
            return false;
        }
        TrieNode tRoot= this.root;
        HashMap<Character, TrieNode>  words;
        int i =0;
        while(i<prefix.length()){
            words = tRoot.children;
            char c = prefix.charAt(i);
            if(!words.containsKey(c)){
                return false;
            }
            tRoot = words.get(c);
            i++;
        }
        return true;
    }
}

class TrieNode {
    char val;
    HashMap<Character,TrieNode> children = null;
    boolean isWord = false;
    public TrieNode(char val, HashMap<Character, TrieNode> children){
        this.val = val;
        this.children = children;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */