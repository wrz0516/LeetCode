package DP;

public class Q122 {
    public int maxProfit(int[] prices){
        int[] dp = new int[prices.length];
        dp[0]=0;
        for(int i=1;i<prices.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-1]+prices[i]-prices[i-1]);
        }
        return dp[prices.length-1];
    }

    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        int res=new Q121().maxProfit(prices);
        System.out.println(res);
    }
}
