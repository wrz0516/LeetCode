package DP;

public class Q746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<=1) return 0;
        int[] dp = new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<dp.length;i++){
             dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];

    }

    public static void main(String[] args) {
        int[] cost={1,100,1,1,1,100,1,1,100,1};
        int res = new Q746().minCostClimbingStairs(cost);
        System.out.println(res);
    }
}
