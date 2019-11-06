package leetcode.problems;

public class MedianOfSortedArrays {
    public static void main(String[] str){
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        Solution sol = new Solution();
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}
class Solution {
    public int start=0;
    public int end,pA, pB;
    public double findMedian(int[] A){
        int len = A.length;
        int mid = len/2;
        if(len%2 ==0){
            return (double)(A[mid] + A[mid-1])/2;
        }else {
            return A[mid];
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int A[];
        int B[];
        if(nums1.length ==0){
            return findMedian(nums2);
        }else if (nums2.length ==0){
            return findMedian(nums1);
        }
        if(nums1.length ==1 && nums2.length==1){
            return (double)(nums1[0]+nums2[0])/2;
        }
        if(nums1.length<=nums2.length){
            end = nums1.length;
            A = nums1;
            B = nums2;
        }else{
            end = nums2.length;
            A = nums2;
            B = nums1;
        }

        int totLen = A.length+B.length;
        int maxLA , maxLB, minRA, minRB;
        while(true){
            pA = (start+end)/2;
            pB = ((totLen+1)/2) - pA;
            int temp = pA+pB;
            if(pA == A.length){
                minRA = (int)Double.POSITIVE_INFINITY;
                maxLA = A[pA-1];
            }else if (pA ==0){
                maxLA = (int) Double.NEGATIVE_INFINITY;
                minRA = A[pA];
            }else {
                minRA = A[pA];
                maxLA = A[pA-1];
            }
            if(pB == 0){
                maxLB = (int) Double.NEGATIVE_INFINITY;
                minRB = B[pB];
            }else if(pB == B.length) {
                minRB = (int)Double.POSITIVE_INFINITY;
                maxLB = B[pB-1];
            }else {
                minRB =  B[pB];
                maxLB = B[pB-1];
            }

            int shouldPart = 0;

            if(maxLB>minRA){
                shouldPart= 1;
            }else if (maxLA > minRB){
                shouldPart= -1;
            }


            if(shouldPart ==0){
                if(temp == totLen-temp){
                    return (double)(Math.max(maxLA,maxLB) + Math.min(minRA,minRB))/2;
                }else {
                    return Math.max(maxLA,maxLB);
                }
            }else if (shouldPart ==1){
                start = pA+1;
                continue;
            }else if (shouldPart ==-1){
                end = pA-1;
                continue;
            }
        }

    }
}

