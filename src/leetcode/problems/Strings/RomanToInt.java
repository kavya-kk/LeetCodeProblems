package leetcode.problems.Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] s){
        RtISol sol = new RtISol();
        System.out.println(sol.romanToInt("IV"));
    }
}

class RtISol {
    Map<String, Integer> rom = new HashMap<String, Integer>();

    private void populateRom(){
        rom.put("I",1);
        rom.put("V",5);
        rom.put("X",10);
        rom.put("L",50);
        rom.put("C",100);
        rom.put("D",500);
        rom.put("M",1000);
    }
    public int romanToInt(String s) {
        populateRom();
        int temp=0;
        int result = 0;
        for(int i=s.length()-1; i>=0; i--){
            int val = rom.get(s.charAt(i)+"");
            if(val >= temp){
                result +=val;
            }else {
                result -=val;
            }
            temp = val;
        }
        return result;
    }
}