package DP;

import HashTable.Q49;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        int len=nums.length;
        int sum = 0;
        if ( target < 0 && sum < -target) return 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if((target+sum)%2!=0) return 0;
        int size=(target+sum)/2;
        int[] dp = new int[size+1];
        dp[0]=1;
        for(int i=0;i<len;i++){
            for(int j=size;j>=nums[i];j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        int target = 3;
        int res = new Q494().findTargetSumWays(nums,target);
        System.out.println(res);
    }
}
