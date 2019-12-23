package PhoneInterviewQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
// Given a list of m words, I’d like to query for the nth most frequent word(s). (e.g. Given 1000 words, tell me
// the 5th most frequent word(s), or the 10th most frequent word(s) etc). Would like to query multiple times for
// different n’s. Solution should be optimized for querying

/*
abc - 5
main - 4
java -10
(java10 ) (abc 5) (main 4)
*/



public class Apptio {

    private static PriorityQueue<WordFreq> queue = new PriorityQueue<>((word1, word2) -> (word2.freq - word1.freq));

    public static void main(String[] args) {
        addWordFreq("cat",5);
        addWordFreq("test",10);
        addWordFreq("dummy",9);

        try{
            System.out.println(getNthFrequentWord(4));
        }catch(Exception e){
            System.out.println("Error Occurred: "+e);
        }

    }

    private static String getNthFrequentWord(int n) throws Exception{
        if(n>queue.size()){
            throw new Exception("Out of bounds");
        }
        List<WordFreq> tempList = new LinkedList<>();
        while(tempList.size()<n){
            tempList.add(queue.poll());
        }
        String word = tempList.get(tempList.size()-1).word;
        for(WordFreq wordFreq: tempList){
            queue.add(wordFreq);
        }

        return word;
    }

    private static void addWordFreq(String word, int freq){

        queue.add(new WordFreq(word,freq));
    }

}

class WordFreq {
    String word;
    int freq;

    public WordFreq(String word, int freq){
        this.word = word;
        this.freq= freq;
    }
}
