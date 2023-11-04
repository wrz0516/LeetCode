package DP;

public class Q377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new  int[target+1];
        dp[0]=1;
//        for(int i=0;i<nums.length;i++){
//            for(int j=nums[i];j<=target;j++){
//                dp[j]+=dp[j-nums[i]];
//            }
//        }
        for(int j=1;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(j>=nums[i]) dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        int target = 4;
        int res = new Q377().combinationSum4(nums,target);
        System.out.println(res);
    }
}
