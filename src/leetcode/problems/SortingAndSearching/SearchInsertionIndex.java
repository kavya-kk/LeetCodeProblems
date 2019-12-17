package leetcode.problems.SortingAndSearching;

public class SearchInsertionIndex {

    public static void main(String[] s){
        int[] a = {};
        int target = 7;
        System.out.println(searchInsertionIndex(a,target));
    }

    private static int searchInsertionIndex(int[] a, int target) {
        int index = -1;
        int length = a.length;
        if(length == 0)
            return 0;
        int low = 0, high = length-1;
        while(low<high){
            int mid = (low+high)/2;
            if(a[mid] == target){
                index = mid;
                break;
            }else if (a[mid] < target){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        if(low >= high){
            index = (a[low]>=target) ? low: low+1;
        }
        if(index == -1){
            index = low;
        }
        return index;
    }
}
