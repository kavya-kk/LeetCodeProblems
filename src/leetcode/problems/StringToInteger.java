package leetcode.problems;

public class StringToInteger {
    public static void main(String[] ss){
        System.out.println(myAtoi("   -11"));
    }
    private static int myAtoi(String str) {
        int times = 1;
        int res = 0;
        if(str.length()==0){
            return 0;
        }
        int i =0;
        //iterate till the first non-whitespace char
        while(i<str.length()){
            if(str.charAt(i)==' '){
                i++;
                continue;
            }else {
                break;
            }
        }
        // return 0 if we have reached the end searching for non-whitespace char
        if(i == str.length()){
            return 0;
        }
        char c = str.charAt(i);
        //check if the 1st non-whitespace char is - or +
        switch(c) {
            case '-':
                times = -1;
                i++;
                break;
            case '+':
                i++;
                break;
        }
        int prevRes = 0;
        while(i<str.length()){
            c = str.charAt(i);
            if(Integer.valueOf(c)<48 || Integer.valueOf(c)>57){
                return res*times;
            }else {
                prevRes = res;
                res = res*10 + Integer.parseInt(c+"");
                if(res/10 != prevRes){
                    res = times == 1 ?  Integer.MAX_VALUE : Integer.MIN_VALUE;
                    break;
                }
            }
            i++;
        }

        return res*times;
    }

}

