package leetcode.problems.General;
// Microsoft Interview question
public class MedianOfConstantlyIncreasingSize {
    public static void main(String[] str){
        Solution s = new Solution();
        s.add(7);
        s.add(8);
        s.add(8);
        s.add(6);
        s.add(6);
        s.add(6);
        s.add(100);
        s.add(100);
        s.add(100);
        s.add(100);
        s.add(100);
        s.add(100);
        System.out.println(s.median());
    }
}

class Solution{
    static int[] freq = new int[101];
    static int count = 0;
    public void add(int num){
        count++;
        freq[num] +=1;
    }

    public float median(){
        int i = count/2;
        int temp = findNum(i+1);
        //if even
        if(count%2 == 0){
            return (float) (temp + findNum(i))/2;
        }else {
            // if odd
            return temp;
        }
    }

    public int findNum(int ith){
        int counter = 0;
        int num=1;
        while(num<freq.length && counter < ith){
            counter+=freq[num++];
        }
        return --num;
    }
}
