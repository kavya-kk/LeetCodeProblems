package leetcode.problems;

//https://leetcode.com/discuss/interview-question/421975/
public class MinDeletionsToBringToRightFormat {
    public static void main(String[] str){
        String s = "ABBABBBAAAABABABBABBBB";
        System.out.println(minDeletions(s));
    }

    private static int minDeletions(String s){
        // assuming min cost is to remove all A's to the right of 0
        int aCount = getCount(s,'A');
        int bCount = 0;
        int minCost = aCount+bCount;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == 'A'){
                aCount--;
            }else {
                bCount++;
            }
            minCost = Math.min(minCost,aCount+bCount);
        }
        return minCost;
    }

    private static int getCount(String s,char c){
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
}
