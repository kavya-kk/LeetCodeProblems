package leetcode.problems.General;

import java.util.HashSet;
//https://leetcode.com/problems/happy-number
public class HappyNumber {
    public static void main(String[] s){
        System.out.println(happyNumber(49));
    }
    private static boolean happyNumber(int n){
        HashSet<Integer> set = new HashSet<Integer>();
        while(true){
            int square = 0;
            System.out.println(n);
            while(n>0){
                square = square + (n%10)*(n%10);
                n/=10;
            }
            //System.out.println(square);
            if(square ==1){
                return true;
            }else if(set.contains(square)){
                return false;
            }else {
                set.add(square);
                n = square;
            }
        }
    }
}
