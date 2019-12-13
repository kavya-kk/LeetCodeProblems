package leetcode.problems.Array;
// an array contains 0s 1s and 2s and not in an order. Arrange them so that all 0s come before 1s and all 1s come before2s.
public class DutchFlagProblem {

    public static void main(String[] s){
        int[] arr = {2,1,0,0,0,2,1,2,1,2,1};
        dutchFlag(arr);
        for(int n: arr){
            System.out.println(n);
        }
    }

    private static void dutchFlag(int[] arr){
        int p0 = 0, p2 = arr.length-1;
        for(int cur = 0;cur<arr.length&& cur<p2;) {
            if (arr[cur] == 0) {
                swap(arr, cur, p0);
                p0++;
                cur++;
            } else if (arr[cur] == 2) {
                swap(arr, cur, p2);
                p2--;
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
