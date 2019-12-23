package leetcode.problems.SortingAndSearching;

public class IsBadVersion {
    public static void main(String[] s){
        int[] a = {0,0,0,1,1};
        System.out.println(firstBadVersion(a));
    }

    private static int firstBadVersion(int[] a) {
        int low = 0, high = a.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if(a[mid] == 0){
                low = mid+1;
            }else{
                if(a[mid-1] == 1){
                    high = mid-1;
                }else {
                    return mid;
                }
            }
        }
        return low;
    }
}
