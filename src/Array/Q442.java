package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            while(nums[i]>0&&nums[i]<=len&&nums[nums[i]-1]!=nums[i]){
                swap(nums,i);
            }
        }
        int i=0;
        for(;i<len;i++){
            if(i!=nums[i]-1) list.add(nums[i]);

        }
        return list;
    }
    public void swap(int[] nums,int i){
        int temp=nums[nums[i]-1];
        nums[nums[i]-1]=nums[i];
        nums[i]=temp;
    }
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> res=new Q442().findDuplicates(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
