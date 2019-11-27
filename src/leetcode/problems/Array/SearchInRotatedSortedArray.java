package leetcode.problems.Array;

public class SearchInRotatedSortedArray {

    public static void main(String[] s){
        int[] a = {3,4,5,6,7,8,0,1,2};
        System.out.println(searchRotatedSortedArr(a,7));
    }

    private static int searchRotatedSortedArr(int[] a, int target){

        if(a.length == 0 || (a.length == 1 && a[0]!= target)){
            return -1;
        }

        int minIdx = findMinIndex(a);
        System.out.println("Min index: "+minIdx);

        if(target == a[minIdx]){
            return minIdx;
        }

        int start = target <= a[a.length-1] ? minIdx:0;
        int end = target > a[a.length-1] ? minIdx-1: a.length-1;

        return binarySearch(a, target, start, end);
    }

    private static int binarySearch(int a[], int target ,int start, int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(a[mid] == target){
            return mid;
        }
        if(target < a[mid]){
            return binarySearch(a,target, start,mid-1);
        }else{
            return binarySearch(a,target, mid+1, end);
        }

    }
    private static int findMinIndex (int[] a){
        int low = 0, high = a.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if(a[mid]>a[high])
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
}
