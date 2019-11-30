package leetcode.problems.Strings;

//https://www.youtube.com/watch?v=GTJr8OvyEVQ
public class IsSubString {
    public static void main(String[] swr){
        String string = "abxabcabcab";
        String s = "abcab";
        System.out.println(isSubString(string, s));
    }

    private static boolean isSubString(String string, String sub){
        int[] arr = prefixArray(sub);
        int i =0,j=0;
        while(i<string.length() && j<sub.length()){
            if(string.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }else {
                if(j-1>0) {
                    j = arr[j - 1];
                }
                if(string.charAt(i) == sub.charAt(j)){
                    continue;
                }else {
                    j=0;
                    i++;
                }
            }
        }
        if(j == sub.length()){
            return true;
        }
        return false;
    }

    private static int[] prefixArray(String sub){
        int[] arr = new int[sub.length()];
        arr[0] = 0;
        int j=0, i= 1;
        while(i<sub.length()){
            if(sub.charAt(j) == sub.charAt(i)){
                arr[i] = j+1;
                j++;
            }else {
                arr[i] = 0;
            }
            i++;
        }
        return arr;
    }
}
