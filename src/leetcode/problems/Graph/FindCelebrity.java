package leetcode.problems.Graph;

public class FindCelebrity {

    public int findCelebrity(int n) {
        int celeb = -1;
        int candidate = 0;
        for(int i =1;i<n;i++){
            if(knows(candidate,i)){
                candidate = i;
            }
        }

        for(int i =0;i<n;i++){
            if(i!=candidate && (!knows(i,candidate) || knows(candidate,i))){
                return celeb;
            }
        }

        return candidate;
    }

    // dummy function
    private boolean knows(int a, int b){
        return true;
    }
}
