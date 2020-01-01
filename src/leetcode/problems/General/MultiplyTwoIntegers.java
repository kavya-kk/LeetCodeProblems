package leetcode.problems.General;

public class MultiplyTwoIntegers {
    public static void main(String[] str) {
        String num1 = "9999999";
        String num2 = "234131231231";
        System.out.println(multiply(num1,num2));
    }
    public static String multiply(String num1, String num2) {
        int[] arr1 = convertToIntArr(num1);
        int[] arr2 = convertToIntArr(num2);

        // as mentioned, only 0 will have leading 0s so, if either of the nums have 0 at first position, the return the result to be 0
        if(arr1[0] == 0 || arr2[0] ==0){
            return "0";
        }

        // start multiplying the numbers
        // max len of resulting number could be num1len + num2len -1
        int result[] = new int [arr1.length + arr2.length];

        // to multiply larger number by smaller number;
        if(num1.length() >= num2.length()){
            multiply(arr1,arr2,result);
        }else {
            multiply(arr2,arr1,result);
        }

        // convert the result int arr to a string and return;
        return convertToString(result);
    }


    private static void multiply(int[] A, int[] B, int[] result){

        for(int i=B.length-1, resIdx=result.length-1;i>=0;i--, resIdx--){
            helper(A,B[i],result, resIdx);
        }
    }

    private static void helper(int[] A, int num, int[] result, int resIdx){

        int remainder = 0;
        for(int j = A.length-1 ;j>=0;j--){
            int prod = (A[j] * num)+remainder+ result[resIdx];

            result[resIdx] = prod%10;
            remainder = prod/10;
            resIdx--;
        }
        while(remainder > 0){
            result[resIdx--] += remainder%10;
            remainder /= 10;
        }

    }
    private static String convertToString(int[] numArr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i< numArr.length;i++){
            if(numArr[i] ==0 && sb.length() ==0){
                continue;
            }
            sb.append(numArr[i]);
        }
        return sb.toString();
    }

    private static int[] convertToIntArr(String num){
        int[] result = new int[num.length()];
        for(int i = 0 ; i < num.length();i++){
            result[i] = num.charAt(i)-'0';
        }
        return result;
    }
}