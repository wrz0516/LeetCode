package DP;

public class Q309 {
    public int maxProfit(int[] prices) {
        /*
        分为四个状态：
        0：买入,或者持续持有
        1：持续卖出
        2：当天卖出
        3：冷冻期
         */
        if(prices.length<=1) return 0;
        int[][] dp = new int[prices.length][4];
        dp[0][0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][1]-prices[i],Math.max(dp[i-1][3]-prices[i],dp[i-1][0]));
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2]=dp[i-1][0]+prices[i];
            dp[i][3]=dp[i-1][2];
        }
        return Math.max(dp[prices.length-1][3],Math.max(dp[prices.length-1][1],dp[prices.length-1][2]));
    }
}
