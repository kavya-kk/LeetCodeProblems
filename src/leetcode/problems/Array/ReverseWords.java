package leetcode.problems.Array;

import java.util.Arrays;

public class ReverseWords {

    public static void main(String[] args) {

        char[] a = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ','m', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        System.out.println(Arrays.toString(reverseWords(a)));
    }

    static char[] reverseWords(char[] arr) {
        // your code goes here
        if(arr.length <=1){
            return arr;
        }

        // reverse the whole array
        int s = 0, e =arr.length-1;
        reverse(arr,s,e);

        //reverse each word;
        s = e =0;
        while(e<arr.length){
            // skip start to non space char
            while(arr[s] == ' '){
                s++;
            }
            // skip end to next white space
            while(e<arr.length && arr[e] != ' ') {
                e++;
            }

            // reverse the word
            reverse(arr,s,e-1);
            s=e;
            e++;
        }
        return arr;
    }
    private static void swap(char[] arr, int s, int e){
        char temp = arr[s];
        arr[s] = arr[e];
        arr[e]= temp;
    }

    private static void reverse(char[] arr, int s, int e){
        while(s <= e){
            swap(arr,s++,e--);
        }
    }

}

