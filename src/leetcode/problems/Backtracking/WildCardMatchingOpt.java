package leetcode.problems.Backtracking;
//https://leetcode.com/problems/wildcard-matching/
public class WildCardMatchingOpt {

    public static void main(String[] agr){
        String string = "adceb";
        String pattern = "a*b";
        System.out.println(isMatch(string, removeDup(pattern)));
    }

    private static boolean isMatch(String string, String pattern){
        int sLen = string.length();
        int pLen = pattern.length();
        if(sLen == 0 && pLen ==0){
            return true;
        }
        int sI = 0, pI = 0;
        int starI = -1, strI = -1;
        while(sI <sLen){
            char s = string.charAt(sI);
            if(pI < pLen && ( pattern.charAt(pI)=='?' || pattern.charAt(pI) == s)){
                ++pI;
                ++sI;
            }else if(pI<pLen && pattern.charAt(pI) =='*'){
                starI = pI;
                strI = sI;
                ++pI;
            } else if(starI == -1){
                return false;
            }else {
                pI = starI+1;
                sI = strI+1;
                strI = sI;
            }
        }
        while(pI!=pLen){
            if(pattern.charAt(pI) != '*'){
                return false;
            }
        }
        return true;
    }

    private static String removeDup(String p){

        String pRes = "";
        int i =0;
        while(i<p.length()){
            if(p.charAt(i) == '*'){
               if (pRes.length() ==0 || pRes.charAt(pRes.length()-1)!='*') {
                   pRes += p.charAt(i++);
               }else {
                   i++;
               }
            }else {
                pRes+=p.charAt(i++);
            }
        }
        return pRes;
    }
}
