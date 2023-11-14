package DP;

public class Q213 {
    public int rob(int[] nums) {
        int res1 = getValue(nums,0,nums.length-2);
        int res2 = getValue(nums,1,nums.length-1);
        return Math.max(res1,res2);
    }

    public int getValue(int[] nums,int start,int end){
        int[] dp = new int[nums.length];
        if(end-start+1==1) return nums[0];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }

}
