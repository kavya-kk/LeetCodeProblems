package leetcode.problems.Strings;

//https://leetcode.com/discuss/interview-question/398026/
public class MinFlipsAvoiding3Consecutives {
    public static void main(String[] po){
        String s = "baaabaababbabbbba";
        System.out.println(minSwaps(s));
    }
    private static int minSwaps(String s){
        int moves = 0;
        for(int i =0;i<s.length();){
            int len = 1;
            int end=i;
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i) != s.charAt(j)){
                    break;
                }else {
                    len++;
                }
            }
            end = i+len-1;
            // if the length of consecutive numbers is greater than 2 something has to be swapped.
            if(len>2){
                // do idealswap
                int index = -1;
                if(len>3){
                    index = i+2;
                    end = index;
                }else {
                    index = idealSwap(s, i, end);
                }
                char c = s.charAt(index) == 'a' ? 'b' : 'a';
                s = s.substring(0,index)+c+s.substring(index+1);
                moves++;
            }
            if(i != end){
                i = end;
            }else {
                i++;
            }
        }
        System.out.println(s);
        return moves;
    }

    private static int idealSwap(String s, int start, int end){
        if(start<=1 || (s.charAt(start-1)!=s.charAt(start-2))){
            return start;
        }
        return end;
    }
}
