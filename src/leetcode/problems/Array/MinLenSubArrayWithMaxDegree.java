package leetcode.problems.Array;

import java.util.HashMap;

//https://leetcode.com/problems/degree-of-an-array/
public class MinLenSubArrayWithMaxDegree {
    public static void main(String[] s){
        int[] a={1,2,3};

        System.out.println(findSubArrayMaxDeg(a));

    }

    private static int findSubArrayMaxDeg(int[] a) {
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        for(int i = 0; i<a.length;i++){
            if(map.containsKey(a[i])){
                //edit the number of occurrences , and end index;
                int[] temp = map.get(a[i]);
                temp[0] = temp[0]+1;
                temp[2] = i;
            }else {
                //{a,b,c} a--> number of occurrences, b--> start index, c--> end index;
                int[] temp = {1,i,i};
                map.put(a[i], temp);
            }
        }

        // analysing the map to get the min length of max deg subarray
        int maxDeg=0, minLength= a.length;
        for (int key:
            map.keySet() ) {
            int[] temp = map.get(key);
            //&& minLength > (temp[2]-temp[1]+1)
            if(maxDeg < temp[0] ||  (maxDeg == temp[0] && minLength > temp[2]-temp[1]+1)){
                maxDeg = temp[0];
                minLength = temp[2]-temp[1]+1;
            }
        }
        return minLength;
    }


}
