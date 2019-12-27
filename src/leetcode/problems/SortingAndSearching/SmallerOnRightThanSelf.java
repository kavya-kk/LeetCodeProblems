package leetcode.problems.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

//Google
//https://leetcode.com/problems/count-of-smaller-numbers-after-self
public class SmallerOnRightThanSelf {

    public static void main(String[] st){
        int[] a = {3,1,2,1,2};
        // invoking the n2 method.
        System.out.println(countSmallerN2(a));

        System.out.println(countSmaller(a));

    }

    // for optimized merge sort approach
    static int[] countArr;
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length ==0){
            return result;
        }

        countArr = new int[nums.length];
        int[] indicesArr = new int[nums.length];
        //initially indices array will have the indices of the elements.
        for(int i =0;i<indicesArr.length;i++){
            indicesArr[i] = i;
        }
        /*
        nums = [4,3,5,1]
        initial indices arr = [0,1,2,3];
        sorted indices arr = [3,1,0,2]; ==> on sorting the nums array the numbers would have moved to these locations;
         */
        // merge sort the indices array based on the values of nums array.
        mergeSort(nums, indicesArr, 0, nums.length-1);

        for(int i: countArr){
            result.add(i);
        }
        return result;
    }

    private static void mergeSort(int[] nums, int[] indicesArr, int start, int end){
        if(end <= start){
            return;
        }

        int mid = (start+end)/2;

        mergeSort(nums,indicesArr, start, mid);
        mergeSort(nums,indicesArr, mid+1,end);

        mergeSortedArr(nums,indicesArr, start,end);
    }

    private static void mergeSortedArr(int[] nums, int[] indicesArr, int start, int end){
        int mid = (start+end)/2;

        // the size of the sortedIndicesArray will the the current section of the indices array that is being sorted.
        int[] sortedIndicesArr = new int[end-start+1];
        // pointed to move on the sortedIndicesArray;
        int sortedIndex = 0;

        // while merging the two arrays within start and end,
        // the left arr will be from start to mid
        // the right arr will be from mid+1 to end;
        int i=start, j = mid+1;
        int rightCount=0;
        while(i <=mid && j<=end){
            // the indices array should be sorted based on the corresponding values at i and j  on the nums array
            if(nums[indicesArr[i]] <= nums[indicesArr[j]]) {
                // ie, if the "value" (nums array) on the leftIndicesArray is lesser than the "value" on the rightIndicesArray
                sortedIndicesArr[sortedIndex] = indicesArr[i];
                countArr[indicesArr[i]] +=rightCount;
                i++;
            }else {
                sortedIndicesArr[sortedIndex] = indicesArr[j];
                rightCount++;
                j++;
            }
            sortedIndex++;
        }
        while(j<=end){
            sortedIndicesArr[sortedIndex] = indicesArr[j];
            sortedIndex++;
            j++;
        }
        while(i<=mid){
            sortedIndicesArr[sortedIndex] = indicesArr[i];
            countArr[indicesArr[i]] +=rightCount;
            sortedIndex++;
            i++;
        }

        // copy the sorted indices values to indices Array from start to end;
        i=0;
        while(i < sortedIndicesArr.length){
            indicesArr[start] = sortedIndicesArr[i];
            i++;
            start++;
        }
    }



    public static List<Integer> countSmallerN2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length ==0){
            return result;
        }

        for(int i =0;i<nums.length;i++){
            int count = 0;
            for(int j = i+1;j<nums.length;j++){
                if(nums[j] < nums[i]){
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }
}
