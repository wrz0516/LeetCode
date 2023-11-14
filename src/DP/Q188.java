package DP;

public class Q188 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length<=1) return 0;
        int[][] dp = new int[prices.length][k*2+1];
        for(int i=1;i<=k*2;){
            dp[0][i]=-prices[0];
            i+=2;
        }
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=2*k;j++){
                if(j%2==0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+prices[i]);
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]-prices[i]);
                }
            }
        }
        return dp[prices.length-1][2*k];
    }
}
