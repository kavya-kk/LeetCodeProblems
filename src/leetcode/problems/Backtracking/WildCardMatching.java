package leetcode.problems.Backtracking;

//https://leetcode.com/problems/wildcard-matching
public class WildCardMatching {
    static boolean[][] visited;
    public static void main(String[] art){
        long start = System.currentTimeMillis();
        boolean hi = isMatch("bababababbabbaabbbbabbbaaaaabbabbbbabaaabbbabbbaabaaaaaaaabbbbaaabababbbabababbbabbabbbbaabbbbabbaabbbabaaababaabbbaaaaaababaaabaaaabbbababbbbaaabbabbbbabaabaabaabbbbbbbaaababbbaaabbbbabbbbbabaabbbaaabbaa","*b*b*bb*ba*a*baa*ab*aa*b*bab*bab*b*b*bbbbab*b*aab*bb*a*abb*aa*b*b*baaaaab*b*");
        System.out.println((System.currentTimeMillis()-start) +""+hi);
    }
    public static boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0){
            return true;
        }
        p = removeDup(p);
        visited = new boolean[s.length()][p.length()];
        return helper(s,p,0,0);

    }

    private static String removeDup(String p){
        int i =0;
        String pRes  = "";
        while(i<p.length()){
            if(p.charAt(i) == '*'){
                if(pRes.length()!=0 && pRes.charAt(pRes.length()-1) =='*'){
                    i++;
                }else {
                    pRes+=p.charAt(i++);
                }
            }else {
                pRes+=p.charAt(i++);
            }
        }
        return pRes;
    }
    private static boolean helper(String string, String pattern, int sI, int pI){
        int sLen = string.length();
        int pLen = pattern.length();
        if(sI==sLen && pI== pLen){
            return true;
        }else if (sI>=sLen && pattern.charAt(pI) == '*'){
            if(pI == pLen-1)
                return true;
            else {
                return helper(string, pattern, sI, pI+1);
            }
        }else if ((sI<sLen && pI == pLen) || (sI == sLen && pI<pLen && pattern.charAt(pI) != '*')){
            return false;
        }
        if(!visited[sI][pI]){
            char s = string.charAt(sI);
            char p = pattern.charAt(pI);
            visited[sI][pI] = true;
            if(Character.isAlphabetic(s) && (Character.isAlphabetic(p)|| p== '?')){
                if(s==p || p == '?'){
                    return helper(string, pattern, sI+1, pI+1);
                }
                else {
                    return false;
                }
            }else if (p == '*'){
                return helper(string, pattern, sI+1, pI+1)|| helper(string,pattern, sI,pI+1) || helper(string, pattern,sI+1,pI);
            }
        }
        return false;
    }

}