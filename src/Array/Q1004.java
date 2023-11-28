package Array;

public class Q1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int num=0; //0的个数
        int res = 0;
        while(right<nums.length){
            if(nums[right]==0) {
                num++;
                while(num>k){
                    if(nums[left++]==0){
                        num--;
                    }
                }
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int res = new Q1004().longestOnes(nums,k);
        System.out.println(res);

    }
}
