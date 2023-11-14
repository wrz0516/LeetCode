package DP;

import java.util.Arrays;

public class Q279 {
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        int[] dp = new int[n+1];

        Arrays.fill(dp,10001);
        dp[0]=0;
        for(int i=1;i<=sqrt;i++){
            for(int j=1;j<=n;j++){
                if(j>=i*i) dp[j]=Math.min(dp[j-i*i]+1,dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n =13;
        int res = new Q279().numSquares(n);
        System.out.println(res);
    }
}
