package leetcode.problems.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimes {
    public static void main(String[] str){
        String[] logs = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        int n = 2;
        int[] times = exclusiveTime(n, Arrays.asList(logs));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {

        // n is the size of processess;
        int[] result = {};

        if(n==0 || logs.size() ==0){
            return result;
        }

        result = new int[n];
        Stack<Integer> stk = new Stack<>();
        int time =0;

        String[] log ;

        for(int i =0;i<logs.size();i++){
            log = logs.get(i).split(":");

            if(log[1].equalsIgnoreCase("start")){
                if(!stk.isEmpty()){
                    result[stk.peek()] += Integer.parseInt(log[2])-time;
                }
                time = Integer.parseInt(log[2]);
                stk.push(Integer.parseInt(log[0]));
            }else {
                result[stk.peek()] += Integer.parseInt(log[2])-time+1;
                stk.pop();
                time = Integer.parseInt(log[2])+1;
            }
        }

        return result;

    }
}
