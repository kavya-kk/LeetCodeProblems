package leetcode.problems.DynamicProgramming;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] str){
        int[] arr = {7,6,4,3,1};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length == 0 ){
            return 0;
        }
        int minPurchase = prices[0];
        int maxProfit = 0;
        for(int i =1;i<prices.length;i++){
            minPurchase =Math.min(prices[i],minPurchase);
            maxProfit = Math.max(maxProfit, prices[i]-minPurchase);
        }
        return maxProfit;
    }
}
