package leetcode.problems.General;

//https://leetcode.com/discuss/interview-question/398047/
public class DaysOfWeek {
    static String[] days = {"mon","tue","wed","thu","fri","sat","sun"};
    public static void main(String[] s){
        System.out.println(dayAfterNDays(days[0],10));
    }

    private static String dayAfterNDays(String s, int n){
        int count = n%7;
        int cur = indexOf(s);
        int newDay = cur+count;
        return newDay>=7 ? days[newDay-7] : days[newDay];

    }

    private static int indexOf(String s){
        for(int i =0;i<days.length;i++){
            if(days[i].equalsIgnoreCase(s)){
                return i;
            }
        }
        return -1;
    }
}
