package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntToRoman {

    static Map<Integer, String> rom = new HashMap<Integer, String>();
    public static void main(String[] str){
        populateRom();
        System.out.println(intToRoman(3985));
    }

    private static void populateRom(){
        rom.put(1,"I");
        rom.put(5,"V");
        rom.put(10,"X");
        rom.put(50,"L");
        rom.put(100,"C");
        rom.put(500,"D");
        rom.put(1000,"M");
    }
    private static String intToRoman(int num) {
        String roman = "";
        List<Integer> arr = getBaseNums(num);
        int mul =1;
        for(int i : arr){
            if(i==0){
                mul*=10;
                continue;
            }
            int n = i/mul;
            switch(n){
                case 1: case 2: case 3:
                    for(int j=0;j<n;j++){
                        roman = rom.get(mul)+ roman;
                    }
                    break;
                case 4: case 5:
                    roman = rom.get(mul*5)+ roman;
                    for(int j=n;j<5;j++){
                        roman = rom.get(mul)+roman;
                    }
                    break;
                case 6: case 7: case 8:
                    for(int j=0;j<n-5;j++){
                        roman = rom.get(mul)+roman;
                    }
                    roman = rom.get(mul*5)+ roman;
                    break;
                case 9:
                    roman = rom.get(mul)+ rom.get(mul*10)+ roman;
                    break;
            }
            mul*=10;
        }
        return roman;
    }
    private static List<Integer> getBaseNums(int num){
        List<Integer> list = new ArrayList<Integer>();
        int mul = 1;
        while (num>0){
            list.add((num%10)*mul);
            mul = mul*10;
            num = num/10;
        }
        System.out.println(list);
        return list;
    }
}

