package leetcode.problems.General;

import java.util.Random;

// given a function random5 that generates random numbers from 0-4
// implement a random7 function that generated random numbers from 0-7 , using only random5 function.
public class Random7 {

    // given function
    public static int random5(){
        Random r = new Random();
        return r.nextInt(5);
    }

    public static int random7() {
        while(true){
            int x = (5*random5() + random5());
            if(x<=20){
                return x%7;
            }
        }
    }

    public static void main(String[] s){
        for(int i = 0 ;i<40;i++){
            System.out.print(random7()+ " ");
        }
    }

}
