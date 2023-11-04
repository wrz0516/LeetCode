package DP;

public class Q343   {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]= Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = new Q343().integerBreak(10);
        System.out.println(res);
    }
}
