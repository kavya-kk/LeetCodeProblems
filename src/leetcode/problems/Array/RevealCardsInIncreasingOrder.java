package leetcode.problems.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/reveal-cards-in-increasing-order/
public class RevealCardsInIncreasingOrder {
    public static void main(String[] str){
        int[] arr = {17,13,11,2,3,5,7};
        System.out.println(deckRevealedIncreasing(arr));
    }
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] resultDeck = new int[deck.length];

        int[] ordering = new int[deck.length];

        Queue<Integer> indices = new LinkedList<>();
        for(int i =0;i<deck.length;i++){
            indices.add(i);
        }

        int i =0;
        while(indices.size()>1){
            ordering[i++] = indices.poll();
            int moveBack = indices.poll();
            indices.add(moveBack);
        }

        ordering[i++] = indices.poll();

        for(i=0;i<resultDeck.length;i++){
            resultDeck[ordering[i]] = deck[i];
        }
        return resultDeck;
    }
}
