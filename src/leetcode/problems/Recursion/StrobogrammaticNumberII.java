package leetcode.problems.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Google
//https://leetcode.com/problems/strobogrammatic-number-ii/
public class StrobogrammaticNumberII {

    public static void main(String[] s){
        int n = 5;
        List<String> result = findStrobogrammatic(n);
        Collections.sort(result);
        System.out.println(result);

    }

    private static List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }

    private static List<String> helper(int n,int m){

        if(m ==0){
            return Arrays.asList("");
        }

        if(m ==1){
            return Arrays.asList("0","1","8");
        }
        List<String> result = new ArrayList<>();
        List<String> temp = helper(n,m-2);

        for(String each: temp){
            if(n!=m)
                result.add("0"+each+"0");
            result.add("1"+each+"1");
            result.add("6"+each+"9");
            result.add("8"+each+"8");
            result.add("9"+each+"6");
        }
        return result;
    }
}
