package leetcode.problems.Strings;
//https://leetcode.com/discuss/interview-question/398050/
public class MaxPossibleValue {

    private static char c = '5';

    public static void main(String[] s){
        int n = -2222;
        System.out.println(maxPossibleValue(n));
    }
    // add 5 at appropriate position to find max possible value
    private static int maxPossibleValue(int n){
        if(n<0){
            int num = minimize(Math.abs(n));
            return (num*-1);
        }else {
            return maximize(n);
        }
    }
    private static int minimize(int n){
        String s = Integer.toString(n);
        for(int i =0;i<s.length();i++){
            c = c;
            if(s.charAt(i) > c){
                if (i==0)
                    return Integer.valueOf(c+s);
                else
                    return Integer.valueOf( s.substring(0,i)+c+s.substring(i));
            }
        }
        return Integer.valueOf(s+c);
    }
    private static int maximize(int n){
        String s = Integer.toString(n);
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) < c){
                if (i==0)
                   return Integer.valueOf(c+s);
                else
                    return Integer.valueOf( s.substring(0,i)+c+s.substring(i));
            }
        }
        return Integer.valueOf(s+c);
    }
}
