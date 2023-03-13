package HashTable;

import java.util.*;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if (nums[i] > 0) {
                return res;
            }
            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int temp=nums[i]+nums[left]+nums[right];
                if(temp<0){
                    left++;
                }
                else if(temp>0){
                    right--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={0,0,0,-1,0,1,2,-1,-4};
        List<List<Integer>> res=new Q15().threeSum(nums);
        for(int i=0;i< res.size();i++){
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }
}
