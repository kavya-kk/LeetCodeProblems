package leetcode.problems.Array;
//https://leetcode.com/discuss/interview-question/428272/
public class ParticleVelocity {
    public static void main(String[] s){
        int[] velocity = {1,3,5,7,7,7,5,4,3,2};
        System.out.println(stablePeriod(velocity));
    }
    public static int stablePeriod(int[] velocity){
        int totalNumOfPeriod =0;
        for(int i =0;i<velocity.length;i++){
            int count = 0;
            while(i+2 <velocity.length && velocity[i+1]-velocity[i] == velocity[i+2]-velocity[i+1]){
                count++;
                totalNumOfPeriod+=count;
                i++;
            }
        }
        return totalNumOfPeriod;
    }
}
