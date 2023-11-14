package DP;

import java.util.Arrays;

public class Q322 {
    public int coinChange(int[] coins, int amount) {
        if(amount<=0) return 0;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,10001);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        if(dp[amount]==10001) return -1;
        return dp[amount]>0?dp[amount]:-1;
    }

    public static void main(String[] args) {
        int[] coins={2,5,10,1};
        int amount = 27;
        int res = new Q322().coinChange(coins,amount);
        System.out.println(res);
    }
}
