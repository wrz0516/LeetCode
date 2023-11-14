package DP;

import lianbiao.Q19;

public class Q198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==1) return nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int res = new Q198().rob(nums);
        System.out.println(res);
    }
}
