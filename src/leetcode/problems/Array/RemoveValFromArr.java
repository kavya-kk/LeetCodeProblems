package leetcode.problems.Array;

public class RemoveValFromArr {

    public static void main(String[] st){
        int[] nums = {3,1};
        int val = 3;
//        // executing the first version
//        Long starttime = System.currentTimeMillis();
//        int len = removeElement(nums,val);
//        Long endTime = System.currentTimeMillis();
//        System.out.println("Time Taken1:"+ (endTime - starttime));
//        for(int i =0;i<len;i++){
//            System.out.print(nums[i]+" ");
//        }

        // executing the easy function;
        System.out.println();
        long starttime = System.currentTimeMillis();
        int len = removeElementOpt(nums,val);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken2:"+ (endTime - starttime));
        for(int i =0;i<len;i++){
            System.out.print(nums[i]+" ");
        }
    }

    // easier code with min lines
    public static int removeElementOpt(int[] a, int val){
        int i =0,j=i;
        while(j<a.length){
            while(j<a.length && a[j] == val)
                j++;
            if(j<a.length)
                a[i++]=a[j++];
        }
        return i;
    }

    // longer code
    public static int removeElement(int[] nums, int val) {
        int cur_len = nums.length;
        int i = cur_len-1;
        while (i>=0) {
            if(nums[i] == val){
                if(cur_len-i >1){
                    int j=i;
                    while(j<cur_len-1){
                        nums[j] = nums[j+1];
                        j++;
                    }
                }
                cur_len--;
            }
            i--;
        }
        return cur_len;
    }


}
