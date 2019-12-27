package leetcode.problems.General;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntToRoman {

    static Map<Integer, String> map = new HashMap<Integer, String>();
    public static void main(String[] str){
        System.out.println(intToRoman(3985));
    }

    public static String intToRoman(int num) {
        String result = "";
        init();
        if(num ==0){
            return result;
        }
        //for num 1994, the nums list will contain [1000,900,90,4];
        List<Integer> nums = new ArrayList<>();
        int position = 1;
        while(num>0){
            nums.add(0,(num%10) * position);
            position*=10;
            num/=10;
        }

        // each item will be converted to the corresponding roman letters and appended to the result;
        position/=10;
        for(int n : nums){
            result+= helper(n,position);
            position/=10;
        }

        return result;
    }

    public static String helper(int n, int position){
        int sigDigit = n/position;
        String res = "";
        switch(sigDigit){
            case 1:
            case 5:
                return map.get(n);
            case 6:
            case 7:
            case 8:
                res = map.get(5*position);
                for(;sigDigit>5;sigDigit--){
                    res+=map.get(position);
                }
                return res;
            case 2:
            case 3:
                for(;sigDigit>0;sigDigit--){
                    res+=map.get(position);
                }
                return res;
            case 4:
            case 9:
                res = sigDigit == 4 ? map.get(5*position) : map.get(10*position);
                res = map.get(position)+res;
                return res;
            default:
                return res;
        }
    }

    public static void init(){
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
    }
}

