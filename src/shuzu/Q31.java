package shuzu;

import java.util.Arrays;

public class Q31 {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int small=0,index_small=-1,index_big=0;
        for (int i=len-1;i>0;i--){
            if (nums[i-1]<nums[i]){
                index_small=i-1;
                break;
            }
        }
        if(index_small==-1){
            Arrays.sort(nums,index_small+1,len);
            return;
        }
        for (int i=len-1;i>=0;i--){
            if(nums[i]>nums[index_small]){
                index_big=i;
                break;
            }
        }
        small=nums[index_small];
        nums[index_small]=nums[index_big];
        nums[index_big]=small;
        Arrays.sort(nums,index_small+1,len);
    }
    public static void main(String[] args) {
        Q31 demo=new Q31();
        int[] x={2,3,1};
//        int target=10;
        demo.nextPermutation(x);
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }

    }
}
