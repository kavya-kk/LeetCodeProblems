package leetcode.problems.Strings;

import java.util.ArrayList;
import java.util.List;

public class IntegerToEnglishWords {
    public static void main(String[] args){
        ToWords s = new ToWords();
       int[] arr = {1111,23,30,100,1000,123456,1234567,10001001};

       for(int n: arr){
           System.out.println(n+" --- "+s.numberToWords(n));
       }
    }
}

class ToWords {
    static String[] general = {"","One ", "Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
    static  String[] tens = {"","","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninty "};
    static  String[] oneInTens = {"Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Ninteen "};
    static  String[] words ={"","Thousand ","Million ","Billion "};

    public String numberToWords(int num) {
        if(num ==0){
            return "Zero";
        }
        // call toWordsHelper for every three digits starting from the end
        List<Integer> split = splitNumber(num);
        // convert each num in split into corresponding words;
        String result= "";
        for(int i =0;i<split.size();i++){
            result = toWordsHelper(split.get(i))+words[i]+result;
        }

        return result;
        //combine them together to form a single word;
    }

    private List<Integer> splitNumber(int num){
        List<Integer> splitNums = new ArrayList<>();
        while(num>0){
            int part = 0;
            int position = 1;
            while(position<1000 && num>0){
                int last = num%10;
                num /= 10;
                part = (part)+(last*position);
                position*=10;
            }
            splitNums.add(part);
        }
        return splitNums;
    }

    private String toWordsHelper(int n){
        int pos =1;
        int prev = 0;
        int curN = 0;
        String res = "";
        while(n>0){
            curN = n%10;
            switch(pos){
                case 1:
                    res= general[curN]+res;
                    break;
                case 10:
                    if(curN ==1){
                        res = oneInTens[prev];
                    }else{
                        res = tens[curN]+res;
                    }
                    break;
                case 100:
                    res= general[curN]+"Hundred "+res;
                    break;
                default:
                    res = "";
            }
            prev = curN;
            pos*=10;
            n/=10;
        }
        return res;
    }
}
