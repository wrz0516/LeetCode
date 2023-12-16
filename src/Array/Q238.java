package Array;

import java.util.Arrays;

public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans=new int[len];
        ans[0]=1;
        for(int i=1;i<len;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        int tmp=1;
        for(int i=len-2;i>=0;i--){
            tmp*=nums[i+1];
            ans[i]*=tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int[] ans = new Q238().productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }
}
