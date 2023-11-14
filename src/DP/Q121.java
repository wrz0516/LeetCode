package DP;

public class Q121 {
    //1、贪心
    public int maxProfit(int[] prices) {
        int res=0;
        int low=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            low = Math.min(low,prices[i]);
            res = Math.max(res,prices[i]-low);
        }
        return res;
    }
    //2、动态规划
//    public int maxProfit(int[] prices) {
//        int[][] dp=new int[prices.length][2];//dp[i][0]表示持有股票，dp[i][1]表示不持有股票
//        dp[0][0]=-prices[0];
//        dp[0][1]=0;
////        int =prices[0];
//        for(int i=1;i<prices.length;i++){
//            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
//            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
//        }
//        return dp[prices.length-1][1];
//    }

    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        int res = new Q121().maxProfit(prices);
        System.out.println(res);
    }
}
