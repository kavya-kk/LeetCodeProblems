package leetcode.problems.Strings;

//https://leetcode.com/discuss/interview-question/366869/
public class LexicographicallySmallestByRemovingAChar {

    public static void main(String[] s){
        String input = "abcdexf";
        System.out.println(lexiSmallest(input));
    }
    private static String lexiSmallest(String input){
        int i =0;
        for(;i<input.length()-1;i++){
            if(input.charAt(i) > input.charAt(i+1)){
                break;
            }
        }
        String output = input.substring(0,i)+input.substring(i+1);
        return output;
    }

}
