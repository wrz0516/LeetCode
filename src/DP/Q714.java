package DP;

public class Q714 {
        public int maxProfit(int[] prices,int fee) {
            int[][] dp=new int[prices.length][2];//dp[i][0]表示持有股票，dp[i][1]表示不持有股票
            dp[0][0]=-prices[0];
            dp[0][1]=0;
    //        int =prices[0];
            for(int i=1;i<prices.length;i++){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
            }
            return dp[prices.length-1][1];
    }

    public static void main(String[] args) {
        int[] prices={1,3,7,5,10,3};
        int fee=3;
        int res = new Q714().maxProfit(prices,fee);
        System.out.println(res);
    }
}
