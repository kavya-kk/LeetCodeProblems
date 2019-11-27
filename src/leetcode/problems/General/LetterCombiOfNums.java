package leetcode.problems.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number
public class LetterCombiOfNums {
    public static List<String> listSt = new ArrayList<String>();
    public static String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] s){
        letterCombinations("23");

        System.out.println(listSt);
    }

    public static void letterCombinations(String digits) {
        for(int i =0; i<digits.length(); i++) {
            formCombi(Integer.parseInt(digits.charAt(i)+""));
        }
    }

    public static void formCombi(int num){
        System.out.println(num);
        if(listSt.isEmpty())
            listSt.addAll(Arrays.asList(map[num].split("")));
        else {
            List<String> hi = new ArrayList<String>();
            for(int i =0 ; i<map[num].length(); i++)
            {
                for (String st : listSt) {
                    hi.add(st+map[num].charAt(i));
                }
            }
            listSt = hi;
        }
    }
}

