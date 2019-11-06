package leetcode.problems;
// with repetitions
public class FindMinInSortedRotatedArray {
    public static void main(String[] s){

        int[] a = {2,2,2,2,2};

        System.out.println(findMin(a));
    }

    public static int findMin(int[] a){
        if(a.length == 0){
            return -1;
        }
        if(a.length == 1) {
            return a[0];
        }

        int lo = 0, hi = a.length-1;
        while(a[lo] == a[hi] && lo!=hi){
            lo++;
        }
        if(a[lo]<= a[hi]){
            return a[lo];
        }
        while (lo <hi){
            int mid = (lo+hi) / 2;

            if(a[mid] > a[hi]){
                lo = mid+1;
            }else {
                hi = mid;
            }
        }
        return a[lo];
    }
}
