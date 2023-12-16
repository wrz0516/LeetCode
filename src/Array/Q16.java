package Array;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            if(res==target) return res;
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(target-sum)<Math.abs(target-res)){
                    res=sum;
                }
                if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={-100,-98,-2,-1};
        int target=-101;
        int res = new Q16().threeSumClosest(nums,target);
        System.out.println(res);
    }
}
