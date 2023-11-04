package DP;

public class Q518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int amount=4;
        int[] coins = {1,2,3};
        int res = new Q518().change(amount,coins);
        System.out.println(res);
    }
}
