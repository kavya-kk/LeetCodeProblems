package leetcode.problems.DynamicProgramming;

import java.util.Arrays;
//https://leetcode.com/problems/coin-change/
public class CoinChange {
    public static void main(String[] str){
        int[] coins = {5,2,1};
        int amount = 10;

        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        if(coins.length ==0){
            return -1;
        }
        if (amount ==0){
            return 0;
        }

        // sort the coins
        Arrays.sort(coins);

        int R = coins.length+1;
        int C = amount+1;
        int[][] dp = new int[R][C];

        // with no coins to form a specific weight is not possible so +inf
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        // with coins with whatever denomination(or with no coins) to form 0 amount is to not pick any coin, thus assign 0
        for(int i =0;i<R;i++){
            dp[i][0] = 0;
        }


        for(int i =1;i<R;i++){
            int curCoin = coins[i-1];
            for(int j=1;j<C;j++){
                if(j<curCoin){
                    dp[i][j] = dp[i-1][j];
                }else if(j==curCoin){
                    dp[i][j] = 1;
                }else{
                    int prevMin = dp[i][j-curCoin];
                    int tempCoinsCount = prevMin == Integer.MAX_VALUE ? prevMin: prevMin+1 ;
                    dp[i][j] = Math.min(dp[i-1][j],tempCoinsCount);
                }
            }
        }
        return dp[R-1][C-1] == Integer.MAX_VALUE ? -1: dp[R-1][C-1];
    }
}
