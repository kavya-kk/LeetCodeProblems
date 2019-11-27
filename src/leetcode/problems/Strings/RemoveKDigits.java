package leetcode.problems.Strings;

//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {
    public static void main(String[] s){
        String input = "10";
        int k = 1;
        System.out.println(removeKdigits(input,k));
    }
    private static String removeKdigits(String input, int k){
        if(k==0) {
            if(input.length() == 0){
                input ="0";
            }else {
                input = removeLeadingZeros(input);
            }
            return input;
        }
        int i =0;
        for(;i<input.length()-1;i++){
            if(input.charAt(i) > input.charAt(i+1)){
                break;
            }
        }
        String output = input.substring(0,i)+input.substring(i+1);
        return removeKdigits(output,k-1);
    }

    private static String removeLeadingZeros(String input){
        int i =0;
        while(i < input.length() && input.charAt(i) =='0'){
            i++;
        }
        return i == input.length() ? "0" : input.substring(i);
    }

}
