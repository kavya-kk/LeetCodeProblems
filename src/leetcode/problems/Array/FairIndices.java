package leetcode.problems.Array;
//https://leetcode.com/discuss/interview-question/451422/
public class FairIndices {
    public static void main(String[] args){
        int[] A = {1,4,2,-2,5};
        int[] B = {7,-2,-2,2,5};

        System.out.println(getFairIndex(A,B));
    }

    private static int getFairIndex(int[] A, int[] B){
        int aSum  = 0;
        int bSum = 0;

        for(int i=0;i<A.length;i++){
            aSum+=A[i];
            bSum+=B[i];
        }

        int aLeft = 0;
        int bLeft = 0;

        int fairIndices = 0;
        int i = 0;
        while(i<A.length){
            aLeft+=A[i];
            aSum-=A[i];

            bLeft+=B[i];
            bSum-=B[i];

            if(aLeft == aSum && bLeft == bSum && bLeft == aSum && i!=0 && i!=A.length-1){
                fairIndices++;
            }
            i++;
        }

        return fairIndices;
    }
}
