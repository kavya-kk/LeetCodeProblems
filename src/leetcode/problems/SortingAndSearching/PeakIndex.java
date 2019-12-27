package leetcode.problems.SortingAndSearching;

public class PeakIndex {

    public static void main(String[] st){
        int[] A = {2,3,4,12,14,21,20,3,2};
        System.out.println(peakIndexInMountainArray(A));
    }
    public static int peakIndexInMountainArray(int[] A) {
        if(A.length < 3) {
            return -1;
        }

        int start = 0;
        int end = A.length-1;
        while(start<end){
            int mid = (start+end)/2;

            if(A[mid] > A[mid-1] && A[mid] < A[mid+1]){
                start = mid+1;
            }else if (A[mid] > A[mid-1] && A[mid] > A[mid+1]){
                return mid;
            }else {
                end = mid-1;
            }
        }

        return start;
    }
}
