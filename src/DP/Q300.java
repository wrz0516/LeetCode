package DP;

import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(dp[i],max);

            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={7,7,7,7,7,7,7};
        int res = new Q300().lengthOfLIS(nums);
        System.out.println(res);
    };


}
