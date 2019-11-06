package leetcode.problems;

public class CountAndSay {
    public static void main(String[] s){
        countAndSay(10);
    }
    private static String countAndSay(int n) {
        String num="1";
        for(int i =1;i<n; i++){
            String newNum = "";
            int counter =0;
            char prevChar =' ';
            for(int j =0;j<num.length();j++){
                if(prevChar == ' '){
                    prevChar = num.charAt(j);
                    counter++;
                }else if(prevChar == num.charAt(j)){
                    counter++;
                }else {
                    newNum = newNum + Integer.toString(counter)+""+prevChar;
                    counter =1;
                    prevChar = num.charAt(j);
                }
            }
            newNum = newNum + Integer.toString(counter)+""+prevChar;
            counter =1;
            num = newNum;
            System.out.println(newNum);
        }

        return num;
    }
}
