package Greedy;

public class Q53 {
    int res=-100000;
    int max=-100000;
    public int maxSubArray(int[] nums) {
         for(int i=0;i<nums.length;i++){
             res = Math.max(res+nums[i],nums[i]);
             max = Math.max(res,max);
         }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int res = new Q53().maxSubArray(nums);
        System.out.println(res);
    }
}
