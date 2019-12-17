package leetcode.problems.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareVersions {

    public static void main(String[] str){
        System.out.print(compareVersion("1","1.1"));

    }
    public static int compareVersion(String version1, String version2) {
        List<String> v1 = new ArrayList<>(Arrays.asList(version1.split("\\.")));
        List<String> v2 = new ArrayList<>( Arrays.asList(version2.split("\\.")));

        //equalize them in length so that comparison is easier
        equalize(v1,v2);

        System.out.println(v1+" "+v2);
        int size = v1.size();
        int i =0;
        while(i < size){
            int sub1 = Integer.parseInt(v1.get(i));
            int sub2 = Integer.parseInt(v2.get(i));
            int comp = sub1-sub2;
            if(comp ==0){
                i++;
                continue;
            }else {
                return comp>0?1:-1;
            }
        }
        return 0;
    }

    public static void equalize(List<String> v1, List<String> v2){
        while(v1.size() < v2.size()){
            v1.add("0");
        }
        while(v2.size() < v1.size()){
            v2.add("0");
        }
    }
}
