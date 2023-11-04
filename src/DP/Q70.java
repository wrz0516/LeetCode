package DP;

public class Q70 {
//    public int climbStairs(int n) {
//        if(n<=1) return n;
//        int[] dp = new int[n+1];
//        dp[0]=0;
//        dp[1]=1;
//        for(int i=2;i<=n;i++){
//            dp[i]=dp[i-1]+dp[i-2];
//        }
//
//        return dp[n];
//    }
    public int climbStairs(int n) {
        if(n<=1) return n;
        int[] dp = new int[n+1];
        int[] nums = {0,1};
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j]) dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[n];
    }
}
