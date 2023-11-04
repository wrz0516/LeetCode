package DP;

public class Q416 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2>0) return false;
        sum = sum/2;
//        int[][] dp = new int[nums.length][sum+1];
//        for(int j=nums[0];j<=sum;j++){
//            dp[0][j]=nums[0];
//        }
//        for(int i=1;i<nums.length;i++){
//            for(int j=0;j<=sum;j++){
//                if(j<nums[i]){
//                    dp[i][j]=dp[i-1][j];
//                }else{
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
//                    if(dp[i][j]==sum) return true;
//                }
//            }
//        }
//        return false;
        int[] dp = new  int[sum+1];
        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                if(dp[j]==sum) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean res = new Q416().canPartition(nums);
        System.out.println(res);
    }
}
