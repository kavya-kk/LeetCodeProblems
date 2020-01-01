package leetcode.problems.Array;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDupArray {
    public static void main(String[] str){
        int[] arr = {0,0,0};
        System.out.println(removeDuplicates(arr));
    }
    private static int removeDuplicates(int[] ar){
        if(ar.length <=1){
            return ar.length;
        }
        int i=0;
        int j = 1;
        while (j<ar.length){
            if(ar[i]== ar[j]){
                j++;
            }else {
                if(i<j-1){
                   ar[i+1] = ar[j];
                }
                i++;
                j++;
            }
        }
        return i+1;
    }

}
